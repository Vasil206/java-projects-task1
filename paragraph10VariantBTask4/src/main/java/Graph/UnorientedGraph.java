/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;
import java.util.TreeSet;

/**
 *
 * @author Acer
 */
public class UnorientedGraph implements IGraph {
    
    private final ArrayList<TreeSet<Integer>> _nodes;
    private final Stack<Integer> _deleted_nodes;
    
    public UnorientedGraph(int size){
        
        _deleted_nodes = new Stack<>();
        _nodes = new ArrayList<>(2 * size);
        
        for(int i = 0; i < size; i++){
            
            _nodes.add(new TreeSet<>());
        }
        
    }

    @Override
    public boolean addEdge(int from, int to) {
        
        if((from < 0) || (from >= _nodes.size())
            || (to < 0) || (to >= _nodes.size())
            || _deleted_nodes.contains(from) || _deleted_nodes.contains(to)){
            
            return false;
        }
        
        return (_nodes.get(from).add(to) && _nodes.get(to).add(from));
    }

    @Override
    public boolean deleteEdge(int from, int to) {
        
        if((from < 0) || (from >= _nodes.size())
            || (to < 0) || (to >= _nodes.size())
            || _deleted_nodes.contains(from) || _deleted_nodes.contains(to)){
            
            return false;
        }
        
        return (_nodes.get(from).remove(to) && _nodes.get(to).remove(from));
    }

    @Override
    public int addNode() {
        
        if(!_deleted_nodes.empty()){
            
            return _deleted_nodes.pop();
        }
        
        _nodes.add(new TreeSet<>());
        return _nodes.size() - 1;
    }

    @Override
    public boolean deleteNode(int nodeNumber) {
        
        if((nodeNumber >= _nodes.size()) || (nodeNumber < 0)
                || _deleted_nodes.contains(nodeNumber)){
            
            return false;
        }
        
        _nodes.forEach(node -> node.remove(nodeNumber));
        
        _nodes.get(nodeNumber).clear();
        _deleted_nodes.push(nodeNumber);
        
        return true;
    }

    @Override
    public Integer[] getNeighbours(int node) throws IllegalArgumentException {

        if((node >= _nodes.size()) || (node < 0)
                || _deleted_nodes.contains(node)){
            
            throw new IllegalArgumentException("UnorientedGraph :"
                    + " not valid parameter 'node'");
        }
        
        return _nodes.get(node).toArray(Integer[]::new);
    }

    @Override
    public int size() {
        
        return _nodes.size() - _deleted_nodes.size();
    }
    
}
