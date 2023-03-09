/* =============================================================

Author : Nikell Reed
Class : ITN262
Class Section : 4C1
Date : 3/21/2022
Assignment : Card Game

================================================================*/

package com.example.warcardgame;

// Setting up the implementation of linked nodes:
public class LinkedNode {

    StackNode head;
    int nodesCount;

    static class StackNode {
        int data;
        StackNode next;

        public int getData() {
            return data;
        }

        public StackNode getNext() {
            return next;
        }

        public StackNode(int data) {
            this.data = data;
        }
    }

    public void push(int data) {
        StackNode newNode = new StackNode(data);

        if (head == null) {
            head = newNode;
        } else {
            StackNode temp = head;
            head = newNode;
            newNode.next = temp;
            this.nodesCount += 1;
        }

    }

    public int pop() {

        int popped = Integer.MIN_VALUE;

        if (isEmpty()) {
            System.out.println("ERROR IN POP METHOD");
        } else {
            popped = head.data;
            head = head.next;
            this.nodesCount -= 1;
        }
        return popped;

    }

    public int peek() {
        if (head == null) {
            System.out.println("Stack is Empty");
            return Integer.MIN_VALUE;
        } else {
            return head.data;
        }
    }

    public boolean isEmpty() {
        if (head == null) {
            return true;
        }
        return false;
    }

     public int length() {
        return this.nodesCount;
    }

    @Override
    public String toString() {
        String result = "";
        StackNode current = head;
        while(current.getNext() != null){
            result += current.getData();
            if(current.getNext() != null){
                result += ", ";
            }
            current = current.getNext();
        }
        return "\t \t \t \t \t \t Winning Card Numbers: " + "\n" + result;
    }
}
