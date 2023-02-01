package org.comicbookret.app;

import org.comicbookret.controller.ComicBookController;
import org.comicbookret.controller.RentalController;
import org.comicbookret.controller.UserController;
import org.comicbookret.dto.ComicBook;
import org.comicbookret.dto.Rental;
import org.comicbookret.dto.User;
import org.comicbookret.factory.Factory;

import java.util.List;
import java.util.Scanner;

public class rentalApp {

    ComicBookController comicBookController = Factory.getInstance().createComicBookController();
    UserController userController = Factory.getInstance().createUserController();
    RentalController rentalController = Factory.getInstance().createRentalController();
    Scanner sc = new Scanner(System.in);

    //test 위해 db에 만화책, 고객 추가하기 위한 메서드
    public void test() {
        comicBookController.create(new ComicBook("슬램덩크1", "작가1"));
        comicBookController.create(new ComicBook("슬램덩크2", "작가2"));
        comicBookController.create(new ComicBook("슬램덩크3", "작가3"));
        userController.create(new User("고객1"));
        userController.create(new User("고객2"));
        userController.create(new User("고객3"));
    }

    //도서대여 프로그램 실행 메서드
    public void start() {
        boolean menu = true;
        while (menu) {
            System.out.println("==========  <메뉴선택>  ==========");
            System.out.println("1. 만화책 조회/등록/수정/삭제");
            System.out.println("2. 고객 조회/등록/수정/삭제");
            System.out.println("3. 만화책 대여/반납");
            System.out.println("0. 프로그램 종료");
            System.out.println("=================================");
            System.out.println();
            System.out.println("입력번호: ");

            try {
                int num = Integer.parseInt(sc.nextLine());

                switch (num) {
                    case 1:
                        bookManage();
                        break;

                    case 2:
                        userManage();
                        break;

                    case 3:
                        rentManage();
                    case 0:
                        System.out.println("프로그램이 종료됩니다.");
                        menu = false;
                        break;
                    default:
                        System.out.println("번호를 다시 입력해주세요");
                }
            } catch (NumberFormatException e) {
                System.out.println("숫자를 입력해주세요.");
            }
        }
    }
    //만화책 조회/등록/수정/삭제 관리 메서드
    public void bookManage() {
        boolean bookManageMenu = true;
        while (bookManageMenu) {
            System.out.println("==========  <메뉴선택>  ==========");
            System.out.println("1. 만화책 목록 보기");
            System.out.println("2. 만화책 찾기");
            System.out.println("3. 만화책 등록");
            System.out.println("4. 만화책 수정");
            System.out.println("5. 만화책 삭제");
            System.out.println("0. 이전 메뉴로 돌아가기");
            System.out.println("=================================");
            System.out.println();
            System.out.println("입력번호: ");

            int num = Integer.parseInt(sc.nextLine());

            switch (num) {
                case 1:
                    List<ComicBook> comicBookList = comicBookController.findAll();
                    System.out.println("====================================");
                    for (int i = 0; i < comicBookList.size(); i++) {
                        System.out.print("만화책 ID: " + comicBookList.get(i).getBookNumber()+"\t");
                        System.out.print("만화책 제목: " + comicBookList.get(i).getTitle()+"\t");
                        System.out.println("작가: " + comicBookList.get(i).getAuthor());
                    }
                    System.out.println("====================================");
                    break;
                case 2:
                    System.out.println("조회할 만화책 제목 입력: ");
                    String title = sc.nextLine();
                    try {
                        ComicBook comicBook = comicBookController.selectOne(title);
                        System.out.println("만화책 ID: " + comicBook.getBookNumber());
                        System.out.println("만화책 제목: " + comicBook.getTitle());
                        System.out.println("작가: " + comicBook.getAuthor());
                    } catch (Exception e) {
                        System.out.println("해당 만화책이 목록에 없습니다.");
                    }
                    break;
                case 3:
                    System.out.println("만화책 제목: ");
                    String createTitle = sc.nextLine();
                    System.out.println("작가명: ");
                    String createAuthor = sc.nextLine();
                    ComicBook createComicBook = new ComicBook(createTitle, createAuthor);
                    comicBookController.create(createComicBook);
                    System.out.println("만화책이 등록되었습니다.");
                    System.out.println("만화책제목: "+createComicBook.getTitle()+" 작가: "+createComicBook.getAuthor()+" 만화책 ID: "+ createComicBook.getBookNumber());
                    break;
                case 4:
                    System.out.println("수정할 만화책 ID 입력: ");
                    int updateNum = Integer.parseInt(sc.nextLine());
                    List<ComicBook> updateComicBookList = comicBookController.findAll();
                    int temp = 0;
                    for (ComicBook c : updateComicBookList) {
                        if (c.getBookNumber() == updateNum) {
                            temp=c.getBookNumber();
                        }
                    }
                    if (temp != 0) {
                        System.out.println("수정할 만화책 제목: ");
                        String updateTitle = sc.nextLine();
                        System.out.println("수정할 작가 이름: ");
                        String updateAuthor = sc.nextLine();
                        comicBookController.update(new ComicBook(updateNum, updateTitle, updateAuthor));
                        System.out.println("수정되었습니다");
                    } else System.out.println("해당 만화책은 목록에 없습니다.");

                    break;
                case 5:
                    System.out.println("삭제할 만화책 이름: ");
                    String deleteTitle = sc.nextLine();
                    try {
                        ComicBook comicBook = comicBookController.selectOne(deleteTitle);
                        comicBookController.delete(comicBook);
                        System.out.println(deleteTitle + " 책이 삭제되었습니다. ");
                    } catch (Exception e) {
                        System.out.println("해당 만화책이 목록에 없습니다.");
                    }
                    break;
                case 0:
                    System.out.println("이전 메뉴로 돌아갑니다.");
                    bookManageMenu = false;
                    break;
                default:
                    System.out.println("번호를 다시 입력해주세요");
                    break;
            }
        }
    }

    //고객 조회/등록/수정/삭제 메서드
    public void userManage() {
        boolean userManageMenu = true;
        while (userManageMenu) {
            System.out.println("==========  <메뉴선택>  ==========");
            System.out.println("1. 고객 목록 보기");
            System.out.println("2. 고객 찾기");
            System.out.println("3. 고객 등록");
            System.out.println("4. 고객 수정");
            System.out.println("5. 고객 삭제");
            System.out.println("0. 이전 메뉴로 돌아가기");
            System.out.println("=================================");
            System.out.println();
            System.out.println("입력번호: ");

            int num = Integer.parseInt(sc.nextLine());

            switch (num) {
                case 1:
                    List<User> userList = userController.findAll();
                    System.out.println("====================================");
                    for (int i = 0; i < userList.size(); i++) {
                        System.out.print("고객 ID: " + userList.get(i).getUserId()+"\t");
                        System.out.println("고객 이름: " + userList.get(i).getUserName()+"\t");
                    }
                    System.out.println("====================================");
                    break;
                case 2:
                    System.out.println("조회할 고객 이름 입력: ");
                    String name = sc.nextLine();
                    try {
                        User user = userController.selectOne(name);
                        System.out.println("고객 ID: " + user.getUserId());
                        System.out.println("고객 이름: " + user.getUserName());
                    } catch (Exception e) {
                        System.out.println("해당 고객은 목록에 없습니다.");
                    }
                    break;
                case 3:
                    System.out.println("등록할 고객 이름: ");
                    String createName = sc.nextLine();
                    User createUser = new User(createName);
                    userController.create(createUser);
                    System.out.println("고객이 등록되었습니다.");
                    System.out.println("이름: "+createUser.getUserName()+" ID: "+ createUser.getUserId());
                    break;
                case 4:
                    //구현 해야함
                    break;
                case 5:
                    System.out.println("삭제할 고객 이름: ");
                    String deleteName = sc.nextLine();
                    try {
                        User user = userController.selectOne(deleteName);
                        userController.delete(user);
                        System.out.println(deleteName + " 고객이 삭제되었습니다. ");
                    } catch (Exception e) {
                        System.out.println("해당 고객이 목록에 없습니다.");
                    }
                    break;
                case 0:
                    System.out.println("이전 메뉴로 돌아갑니다.");
                    userManageMenu = false;
                    break;
                default:
                    System.out.println("번호를 다시 입력해주세요");
                    break;
            }
        }
    }

    // 만화책 대여/반납 메서드
    public void rentManage() {
        boolean rentManageMenu = true;
        while (rentManageMenu) {
            System.out.println("==========  <메뉴선택>  ==========");
            System.out.println("1. 대여현황");
            System.out.println("2. 대여하기");
            System.out.println("3. 반납하기");
            System.out.println("0. 이전 메뉴로 돌아가기");
            System.out.println("=================================");
            System.out.println();
            System.out.println("입력번호: ");

            int num = Integer.parseInt(sc.nextLine());

            switch (num) {

                case 1:
                    List<Rental> list = rentalController.findAll();
                    System.out.println("====================================");
                    for (int i = 0; i < list.size(); i++) {
                        System.out.print("대여도서 제목: "+ list.get(i).getRentBookTitle()+"\t");
                        System.out.println("대여도서 ID: "+ list.get(i).getRentId());
                    }
                    System.out.println("====================================");
                    break;
                case 2:
                    System.out.println("대여할 도서 제목: ");
                    String rentBookTitle = sc.nextLine();
                    if (comicBookController.selectOne(rentBookTitle) == null) {
                        System.out.println("해당 도서는 보유하고 있지 않습니다.");
                    } else if (rentalController.selectOne(rentBookTitle) != null) {
                        System.out.println("해당 도서는 이미 대여중입니다.");
                    } else {
                        Rental rental = new Rental(rentBookTitle);
                        rentalController.create(rental);
                        System.out.println("<"+rental.getRentBookTitle()+"> 이 성공적으로 대여되었습니다.");
                    }
                    break;
                case 3:
                    System.out.println("반납할 도서: ");
                    String returnBookTitle = sc.nextLine();
                    if (rentalController.selectOne(returnBookTitle) == null) {
                        System.out.println("해당 도서는 대여중이지 않습니다.");

                    } else {
                        Rental returnRental = rentalController.selectOne(returnBookTitle);
                        rentalController.delete(returnRental);
                        System.out.println("<"+returnRental.getRentBookTitle()+"> 이 성공적으로 반납되었습니다.");
                    }
                    break;
                case 0:
                    System.out.println("이전 메뉴로 돌아갑니다.");
                    rentManageMenu = false;
                    break;
                default:
                    System.out.println("번호를 다시 입력해주세요");
                    break;

            }
        }
    }
}
