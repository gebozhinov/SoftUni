package bg.softuni.Pathfinder.service;

import bg.softuni.Pathfinder.model.Comments;
import bg.softuni.Pathfinder.model.User;
import bg.softuni.Pathfinder.model.dto.CommentDTO;
import bg.softuni.Pathfinder.repository.CommentRepository;
import bg.softuni.Pathfinder.repository.RouteRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CommentService {

    private final CommentRepository commentRepository;
    private final RouteRepository routeRepository;

    public CommentService(CommentRepository commentRepository,
                          RouteRepository routeRepository) {
        this.commentRepository = commentRepository;
        this.routeRepository = routeRepository;
    }

    public List<Comments> getCommentByRouteId(Long id) {
        return this.commentRepository.findAllByRoute(this.routeRepository.findById(id).get());
    }

    public Comments createComment(CommentDTO commentDTO, Long id, User author) {

        Comments comment = new Comments();
        comment.setCreated(LocalDateTime.now());
        comment.setRoute(this.routeRepository.findById(id).get());
        comment.setAuthor(author);
        comment.setTextContent(commentDTO.getText());
        comment.setApproved(true);

        this.commentRepository.save(comment);

        return comment;

    }
    public Comments getComment(Long id) {
        return this.commentRepository.findById(id).get();
    }

    public Comments deleteComment(Long id) {
        Comments comment = this.getComment(id);
        this.commentRepository.delete(comment);

        return comment;
    }
}
