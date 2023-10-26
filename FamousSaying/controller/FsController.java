package _23_10_24.FamousSaying.controller;

import _23_10_24.FamousSaying.model.FsRepository;
import _23_10_24.FamousSaying.model.fsData;

import java.util.ArrayList;
import java.util.Scanner;

public class FsController {
    Long id;
    String fs;
    String author;
    FsRepository fsRepository= new FsRepository();
    public void register(long Id, String[] strings) {

        fsRepository.add(Id, strings[0], strings[1]);
        System.out.println(Id + "번 명령이 등록되었습니다.");
    }

    public void delete(int id) {
        if (fsRepository.delete(id)) {
            System.out.println(id + "번 명언을 삭제했습니다.");
        }else{
            System.out.println(id + "번 명언은 존재하지 않습니다.");
        }
    }

    public void modify(int id, String[] strings) {
        fsRepository.replace(id, strings[0], strings[1]);
    }

    public void saveFile(){
        fsRepository.saveFile();
    }

    public void build() {
        fsRepository.build();
    }
}
