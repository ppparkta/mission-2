package menu.model;

import menu.util.ExceptionMessage;

public enum Category {
    JAPANESE("일식", 1),
    KOREAN("한식", 2),
    CHINESE("중식", 3),
    ASIAN("아시안", 4),
    WESTERN("양식", 5),
    ;

    private final String category;
    private final int categoryNumber;

    Category(String category, int categoryNumber) {
        this.category = category;
        this.categoryNumber = categoryNumber;
    }

    public String getCategory() {
        return category;
    }

    public static Category pickCategory(int number) {
        for (Category value : values()) {
            if (value.categoryNumber == number) {
                return value;
            }
        }
        throw new IllegalArgumentException(ExceptionMessage.CATEGORY_NUMBER_ERROR.getMessage());
    }
}
