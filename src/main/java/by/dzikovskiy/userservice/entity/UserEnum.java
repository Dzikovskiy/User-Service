package by.dzikovskiy.userservice.entity;

public enum UserEnum {
    USER(1), CUSTOMER(1), ADMIN(2), PROVIDER(2), SUPER_ADMIN(3);

    private final int level;

    UserEnum(int level) {
        this.level = level;
    }

    public int getLevel() {
        return this.level;
    }

}
