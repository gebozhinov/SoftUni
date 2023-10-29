package bg.softuni.Pathfinder.web;

import bg.softuni.Pathfinder.model.Comments;
import bg.softuni.Pathfinder.model.User;
import bg.softuni.Pathfinder.model.dto.CommentDTO;
import bg.softuni.Pathfinder.model.view.CommentView;
import bg.softuni.Pathfinder.service.AuthService;
import bg.softuni.Pathfinder.service.CommentService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.security.Principal;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

import static bg.softuni.Pathfinder.model.enums.UserRole.ADMIN;
import static bg.softuni.Pathfinder.model.enums.UserRole.MODERATOR;

@RestController
public class CommentRestController {

    private final CommentService commentService;
    private final AuthService authService;

    public CommentRestController(CommentService commentService, AuthService authService) {
        this.commentService = commentService;
        this.authService = authService;
    }

    @GetMapping("/api/{routeId}/comments")
    public ResponseEntity<List<CommentView>> getCommentsRoute(@PathVariable("routeId") Long routeId) {

        var comments = this.commentService.getCommentByRouteId(routeId)
                .stream().map(this::mapToCommentView)
                .collect(Collectors.toList());


        return ResponseEntity.ok(comments);

    }

    @GetMapping("/api/{routeId}/comments/{commentId}")
    public ResponseEntity<CommentView> getComment(@PathVariable("commentId") Long commentId) {
        return ResponseEntity.ok(mapToCommentView(this.commentService.getComment(commentId)));
    }

    @PostMapping(value = "/api/{routeId}/comments", consumes = "application/json")
    public ResponseEntity<CommentView> createComment(@AuthenticationPrincipal UserDetails userDetails,
                                                     @RequestBody CommentDTO commentDTO,
                                                     @PathVariable("routeId") Long routeId) {


        Comments comment =
                this.commentService
                        .createComment(commentDTO, routeId, this.authService.findUserByUsername(userDetails.getUsername()));

        CommentView commentView = mapToCommentView(comment);

        return ResponseEntity.created(URI.create(String.format("/api/%s/comments/%d", routeId, comment.getId())))
                .body(commentView);
    }

    @DeleteMapping("/api/{routeId}/comments/{commentId}")
    public ResponseEntity<CommentView> deleteComment(@PathVariable("commentId") Long commentId,
                                                     @AuthenticationPrincipal UserDetails userDetails) {

        User user = this.authService.findUserByUsername(userDetails.getUsername());
        Comments comment = this.commentService.getComment(commentId);

        if (user.getRoles().stream().anyMatch(r -> r.getRole().name().equals(MODERATOR.name()) ||
                r.getRole().name().equals(ADMIN.name())) ||
                        user.getId().longValue() == comment.getAuthor().getId().longValue()) {
                Comments deleted = this.commentService.deleteComment(commentId);

                return ResponseEntity.ok(mapToCommentView(deleted));


        }

        return ResponseEntity.status(403).build();

    }

    private CommentView mapToCommentView(Comments c) {
        return new CommentView(
                c.getId(),
                c.getTextContent(),
                c.getAuthor().getFullName(),
                c.getCreated().format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm")));
    }
}
