import entities.Project;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.List;

public class FindLatest10Projects {
    public static void main(String[] args) {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("soft_uni");
        EntityManager entityManager = factory.createEntityManager();

        List<Project> projects = entityManager.createQuery("SELECT p FROM Project p " +
                        "ORDER BY p.startDate DESC", Project.class)
                .setMaxResults(10)
                .getResultList();


        projects.stream().sorted(Comparator.comparing(Project::getName))
                        .forEach(project -> {
                            System.out.printf("Project name: %s%n" +
                                            "Project Description: %s%n" +
                                            "Project Start Date:%s%n" +
                                            "Project End Date: %s%n",
                                    project.getName(),
                                    project.getDescription(),
                                    project.getStartDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")),
                                    project.getEndDate() == null ? "null" :
                                            project.getEndDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
                        });

        entityManager.close();
    }
}
