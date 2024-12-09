package menu.view;

import java.util.List;
import menu.model.Category;
import menu.model.Coach;
import menu.model.Coaches;

public class OutputView {
    public void printStartMessage() {
        System.out.println("점심 메뉴 추천을 시작합니다.\n");
    }

    public void printMenuResult(List<Category> categories, Coaches coaches) {
        printHeader();
        printCategories(categories);
        for (Coach coach : coaches.getCoaches()) {
            printCoachWeeklyMenu(coach);
        }
        printFooter();
    }

    private void printFooter() {
        System.out.println("\n추천을 완료했습니다.");
    }

    private void printCoachWeeklyMenu(Coach coach) {
        System.out.print("[ " + coach.getName() + " ");
        for (String menu : coach.getWeeklyMenus()) {
            System.out.print("| " + menu + " ");
        }
        System.out.println("]");
    }

    private void printCategories(List<Category> categories) {
        System.out.print("[ 카테고리 ");
        for (Category category : categories) {
            System.out.print("| " + category.getCategory() + " ");
        }
        System.out.println("]");
    }

    private void printHeader() {
        System.out.println("메뉴 추천 결과입니다.");
        System.out.println("[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]");
    }
}
