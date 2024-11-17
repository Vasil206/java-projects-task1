/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Graph;

/**
 *
 * interface for any graph
 * 
 * @author Acer
 */
public interface IGraph {
    
    /**
     * add an edge between two nodes
     * 
     * @param from
     * @param to
     * @return true, if successful, false, if edge already exists or cannot be added
     */
    boolean addEdge(int from, int to);
    
    /**
     * delete an edge between two nodes
     * 
     * @param from
     * @param to
     * @return true, if successful, false, if edge already exists or cannot be deleted
     */
    boolean deleteEdge(int from, int to);
    
    /**
     * insert a node
     * 
     * @return number of new node, starting from 0
     */
    int addNode();
    
    /**
     * delete a node with its all edges
     * 
     * @param nodeNumber
     * @return true, if successful, false, if incorrect nodeNumber
     */
    boolean deleteNode(int nodeNumber);
    
    /**
     *
     * @param nodeNumber
     * @return array whit numbers of nodes neighbor of node.
     */
    Integer[] getNeighbours(int nodeNumber);
    
    /**
     *
     * @return number of nodes
     */
    int size();
}
