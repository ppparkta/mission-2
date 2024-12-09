package menu.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import menu.model.Category;
import menu.util.MenuConfig;
import menu.util.WeekConfig;

public class CategoryService {
    public List<Category> pickWeeklyCategories() {
        List<Category> categories = new ArrayList<>();
        while (categories.size() < WeekConfig.MAX.getValue()) {
            Category category = Category.pickCategory(Randoms.pickNumberInRange(1, WeekConfig.MAX.getValue()));
            if (fullCategoryCount(categories, category)) {
                continue;
            }
            categories.add(category);
        }
        return categories;
    }

    private boolean fullCategoryCount(List<Category> categories, Category category) {
        long count = categories.stream()
                .filter(cursorCategory -> cursorCategory.name().equals(category.name()))
                .count();
        return (count > MenuConfig.MAX_PICKY_MENU_SIZE.getValue() - 1);
    }
}
