package dataStuctures;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class HashTableTest {


    HashTable hashTable=new HashTable<>(10);

    @Test
    public void hashTableSizeTest(){

        boolean pass=false;


        if(10==hashTable.getCapacity()){
            pass=true;
        }

        assertTrue(pass);

    }


    @Test
    public void hashInsertSuccessfullyTest(){

        boolean pass=false;
        //Arrange
        hashTable.insert("indexUno",100);

        //act
        if(hashTable.get("indexUno").equals(100)){
            pass=true;

        }

        //Arrange
        assertTrue(pass);


    }
    //insertar donde habia un elemento

    @Test
    public void hashInsertWithSameKey(){

        boolean pass=false;

        //Arrange
        hashTable.insert("indexUno",200);
        hashTable.insert("indexUno",500);

        //Act
        if(hashTable.get("indexUno").equals(500)){
            pass=true;
        }

        assertTrue(pass);
    }



    @Test
    public void getSuccessfullyTest(){

        boolean pass=false;

        //arrange
        hashTable.insert("primerIndex",500);

        //act
        if(hashTable.get("primerIndex").equals(500)){
            pass=true;
        }

        assertTrue(pass);
    }




    //almacenar donde habia un elemento
    @Test
    public void insertAndGetValueWhereWasAnItem(){

        boolean pass=false;
        //Arrange
        hashTable.insert("index",1);
        hashTable.remove("index");
        hashTable.insert("index",50);

        if(hashTable.get("index").equals(50)){
            pass=true;
        }

        assertTrue(pass);
    }












    //borrar donde habia uno
    @Test
    public void removeAgainWithTheSameKey(){

        boolean pass=false;
        //arrange
        hashTable.insert("hola",1);
        hashTable.remove("hola");
        hashTable.insert("hola",4545);

        //act
        if(hashTable.get("hola").equals(4545)){
            pass=true;
        }

        //assert
        assertTrue(pass);


    }


}
