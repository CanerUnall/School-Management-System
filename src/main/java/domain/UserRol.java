package domain;

public enum UserRol {
    ADMIN("Admin"),
    TEACHER("Teacher"),
    STUDENT("Student");

    private String roleName;

    UserRol(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleName() {
        return roleName;
    }

    public static UserRol fromString(String roleString) {
        for (UserRol role : UserRol.values()) {
            if (role.getRoleName().equalsIgnoreCase(roleString)) {
                return role;
            }
        }
        throw new IllegalArgumentException("Invalid UserRole: " + roleString);
    }
}
