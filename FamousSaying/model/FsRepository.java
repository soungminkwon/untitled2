package _23_10_24.FamousSaying.model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.util.ArrayList;

public class FsRepository {
    public static ArrayList<fsData> fsDataArrayList = new ArrayList<>();


    public FsRepository() {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("arr.ser"))) {
            fsDataArrayList = (ArrayList<fsData>) inputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public int size(){
        return fsDataArrayList.size();
    }

    public Long add(Long id, String famousSaying, String author){

        fsData fsd = new fsData(id, famousSaying, author);
        fsDataArrayList.add(fsd);
        return id;
    }

    public void printAll(){
        for(int i = fsDataArrayList.size() -1; i >= 0; i--){
            System.out.println(fsDataArrayList.get(i).id + " / " + fsDataArrayList.get(i).author + " / " + fsDataArrayList.get(i).fas);
        }
    }
    public boolean delete(int id){
        boolean flag = false;
        for(int i = 0 ; i < fsDataArrayList.size(); i++){
            if(fsDataArrayList.get(i).id == id){
                fsDataArrayList.remove(i);
                flag = true;
            }
        }

        return flag;
    }

    public fsData find(int id){
        fsData fsData = new fsData();
        for(int i = 0; i < fsDataArrayList.size(); i++){
            if(fsDataArrayList.get(i).id == id){
                fsData = fsDataArrayList.get(i);
            }
        }

        return fsData;
    }

    public void replace(int id, String fas, String author){
        for(int i = 0 ; i < fsDataArrayList.size(); i++){
            if(fsDataArrayList.get(i).id == id){
                fsDataArrayList.get(i).setAuthor(author);
                fsDataArrayList.get(i).setFas(fas);
                break;
            }
        }
    }

    public void saveFile() {
        //파일에 ArrayList 생성
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("arr.ser"))) {
            outputStream.writeObject(fsDataArrayList);
            System.out.println("ArrayList를 파일에 쓰기 완료.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void build() {
        Gson gson = new GsonBuilder().setPrettyPrinting().create(); //Gson인스턴스 생성
        String jsonString = gson.toJson(fsDataArrayList); // ArrayListfmf JSON문자열로 변환

        //JSON을 파일로 저장
        try (FileWriter writer = new FileWriter("arr.json")) {
            writer.write(jsonString);
            System.out.println("JSON파일로 쓰기 완료");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
