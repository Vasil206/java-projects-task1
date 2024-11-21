/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package task4.paragraph10variantbtask4;

import Graph.UnorientedGraph;

/**
 * chapter 2, paragraph 10, variant 4, task 4
 * 
 * Реализовать класс Graph, представляющий собой неориентированный 
 * граф. В конструкторе класса передается количество вершин в графе. 
 * Методы должны поддерживать быстрое добавление и удаление ребер.
 * 
 * @author Acer
 */
public class Paragraph10VariantBTask4 {

    public static void main(String[] args) {
        
        UnorientedGraph graph = new UnorientedGraph(10);
        
        /* everything below should be random in a test class */
        graph.addEdge(0, 5);
        graph.addEdge(0, 3);
        int newNode = graph.addNode();
        graph.addEdge(newNode, 5);
        graph.deleteNode(0);
        newNode = graph.addNode();
        graph.addEdge(newNode, 10);
        graph.addEdge(3, 5);
        
        System.out.println("neighbours of 0");
        for(var i : graph.getNeighbours(0)){
            System.out.println(i);
        }
        
        System.out.println("neighbours of 5");
        for(var i : graph.getNeighbours(5)){
            System.out.println(i);
        }
        
        System.out.println("neighbours of 3");
        for(var i : graph.getNeighbours(3)){
            System.out.println(i);
        }
        
        System.out.println("neighbours of 6");
        for(var i : graph.getNeighbours(6)){
            System.out.println(i);
        }
        
        System.out.println("neighbours of 31");
        try{
        graph.getNeighbours(31);
        } catch(IllegalArgumentException ex){
            System.out.println(ex.getMessage());
        }
    }
}
