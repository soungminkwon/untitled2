package _23_10_24.FamousSaying.view;

import _23_10_24.FamousSaying.model.FsRepository;
import _23_10_24.FamousSaying.model.fsData;

import java.util.Scanner;

public class ConsoleView {

    Scanner sc = new Scanner(System.in);
    FsRepository fsRepository = new FsRepository();

    public void printList() {
        System.out.println("번호 / 작가 / 명언");
        System.out.println("----------------------------------------------");
        fsRepository.printAll();
    }

    public String[] printRegister(){
        String[] strArr = new String[2];
        System.out.print("명언 : ");
        strArr[0] = sc.nextLine();
        System.out.print("작가 : ");
        strArr[1] = sc.nextLine();
        return strArr;
    }

    public String[] printModify(int id){
        fsData fsData = fsRepository.find(id);
        String[] strArr = new String[2];
        System.out.println("명언(기존) : " + fsData.getFas());
        System.out.print("명언 : ");
        strArr[0] = sc.nextLine();
        System.out.println("작가(기존) : " + fsData.getAuthor());
        System.out.print("작가 : ");
        strArr[1] = sc.nextLine();
        return strArr;
    }
}
