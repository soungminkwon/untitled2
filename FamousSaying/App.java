package _23_10_24.FamousSaying;

import _23_10_24.FamousSaying.controller.FsController;
import _23_10_24.FamousSaying.model.FsRepository;
import _23_10_24.FamousSaying.view.ConsoleView;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class App {
    void run(){
        String order;
        long topId = 0;
        FsRepository fsRepository = new FsRepository();
        ConsoleView consoleView = new ConsoleView();
        FsController fsController = new FsController();
        topId = fsRepository.size();


        String buffer;
        Scanner sc = new Scanner(System.in);
        System.out.println("== 명언 앱 ==");

        while (true) {
            System.out.print("명령) ");
            order = sc.next();
            System.out.println();
            int id = 0;
            if (order.length() >= 3) {
                String[] split = order.split("=");
                order = split[0];
                order = order.substring(0, 2);
                id = Integer.parseInt(split[1]);
            }


            if (order.equals("등록")) {
                String[] strings = consoleView.printRegister();
                fsController.register(++topId, strings);
            } else if (order.equals("종료")) {
                fsController.saveFile();
                break;
            } else if (order.equals("목록")) {
                consoleView.printList();
            } else if (order.equals("삭제")) {
                fsController.delete(id);
            } else if (order.equals("수정")) {
                String[] strings = consoleView.printModify(id);
                fsController.modify(id, strings);
            } else if (order.equals("빌드")) {
                fsController.build();
            } else {
                System.out.println("잘못 입력하셨습니다. 다시 입력해주세요");
            }
        }
    }
}
