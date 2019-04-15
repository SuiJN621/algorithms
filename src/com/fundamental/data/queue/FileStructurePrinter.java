package com.fundamental.data.queue;

import java.io.File;

/**
 * @author Sui
 * @date 2018/5/29 15:54
 */
//TODO:增加缩进
public class FileStructurePrinter {

    private ArrayQueue<String> fileQueue = new ArrayQueue<>();

    public static void main(String[] args) {
        FileStructurePrinter fileStructurePrinter = new FileStructurePrinter();
        fileStructurePrinter.printFileStructure(new File("C:\\opt"));
        ArrayQueue<String> fileQueue = fileStructurePrinter.fileQueue;
        while (!fileQueue.isEmpty()){
            System.out.println(fileQueue.dequeue());
        }
    }

    private void printFileStructure(File file){
        fileQueue.enqueue(file.getName());
        if(file.isDirectory()){
            for (File subFile : file.listFiles()) {
                if (subFile.isDirectory()) {
                    printFileStructure(subFile);
                } else {
                    fileQueue.enqueue(subFile.getName());
                }
            }
        }
    }
}
