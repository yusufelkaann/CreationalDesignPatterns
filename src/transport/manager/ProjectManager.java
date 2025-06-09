package transport.manager;

import transport.model.Project;

import java.util.ArrayList;
import java.util.List;

public class ProjectManager {
    private static ProjectManager instance;
    private List<Project> projects;

    private ProjectManager() {
        this.projects = new ArrayList<>();
    }

    public static ProjectManager getInstance() {
        if (instance == null) {
            instance = new ProjectManager();
        }
        return instance;
    }

    public void addProject(Project project) {
        if (project != null) {
            projects.add(project);
        }
    }

    public List<Project> getProjects() {
        return new ArrayList<>(projects); // Defensive copy
    }
}