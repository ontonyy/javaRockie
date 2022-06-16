package com.ontony.blockchaininterface.blockchain;

import com.ontony.blockchaininterface.blockchain.Block;
import com.ontony.blockchaininterface.blockchain.BlockChain;

import java.util.List;

public class User {
    public String name;
    public int balance;
    public BlockChain userBlockChain = new BlockChain();

    public User(String name, int balance) {
        this.name = name;
        this.balance = balance;
    }

    public BlockChain getBlockChain() {
        return userBlockChain;
    }

    public List<Block> getBlocks() {
        return userBlockChain.getBlocks().subList(1, userBlockChain.getBlocks().size());
    }

    public void reduceBalance(int amount) {
        this.balance -= amount;
    }

    public void addBalance(int amount) {
        this.balance += amount;
    }

    public int getBalance() {
        return balance;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", balance=" + balance +
                ", userBlockChain=" + userBlockChain +
                '}';
    }

    public String getUsableString() {
        return "User: " + name +
                "\nbalance: " + balance + "$" +
                "\nblocks: " + (userBlockChain.blocks.size() - 1);
    }
}
