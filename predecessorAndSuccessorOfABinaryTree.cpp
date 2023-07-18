#include <bits/stdc++.h> 
/*************************************************************

    Following is the Binary Tree node structure

    template <typename T>

    class BinaryTreeNode
    {
    public :
        T data;
        BinaryTreeNode<T> *left;
        BinaryTreeNode<T> *right;

        BinaryTreeNode(T data) {
            this -> data = data;
            left = NULL;
            right = NULL;
        }

        ~BinaryTreeNode() {
            if (left)
            {
                delete left;
            }
            if (right)
            {
                delete right;
            }
        }
    };

*************************************************************/
pair<int,int> predecessorSuccessor(BinaryTreeNode<int>* root, int key)
{
    int suc = -1;
    BinaryTreeNode<int>* cur = root;
    while(cur) {
        if(cur->data > key){
            suc = cur->data;
            cur = cur->left;
        }
        else{
            cur = cur->right;
        }

    }
    int pre = -1;
    while(root){
        if(root->data < key){
            pre = root->data;
            root = root->right;
        }
        else{
            root = root->left;
        }
    }
    return {pre, suc};
}

