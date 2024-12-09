package menu.util;

public enum ExceptionMessage {
    NAME_LENGTH_ERROR("이름은 2자 이상 4자 이하여야 합니다."),
    NAME_DUPLICATED_ERROR("이름은 중복될 수 없습니다."),

    CATEGORY_NUMBER_ERROR("정해진 카테고리 안에서 골라야 합니다."),

    PICKY_MENU_SIZE_ERROR("못 먹는 음식은 2개 이하여야 합니다."),
    PICKY_MENU_DUPLICATED_ERROR("못 먹는 음식은 중복될 수 없습니다."),
    PICKY_MENU_SELECTED_ERROR("못 먹는 음식은 중복될 수 없습니다."),
    PICKY_MENU_NOT_FOUND_ERROR("존재하지 않는 메뉴는 입력할 수 없습니다."),

    WEEKLY_MENU_DUPLICATED_ERROR("한 주의 메뉴는 중복될 수 없습니다."),
    WEEKLY_MENU_SIZE_ERROR("한 주의 메뉴는 5개까지만 선택할 수 있습니다."),

    COACHES_SIZE_ERROR("코치는 2명 이상, 5명 이하만 함께 식사할 수 있습니다."),
    ;

    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return "[ERROR] " + message;
    }
}
