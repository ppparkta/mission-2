package menu.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import menu.model.Category;

public class CategoryService {
    public List<Category> pickCategories() {
        List<Category> categories = new ArrayList<>();
        while (categories.size() < 5) {
            Category category = Category.pickCategory(Randoms.pickNumberInRange(1, 5));
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
        return (count > 1);
    }
}
