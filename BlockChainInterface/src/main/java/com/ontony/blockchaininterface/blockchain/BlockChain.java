package com.ontony.blockchaininterface.blockchain;


import java.util.LinkedList;
import java.util.List;

public class BlockChain {
    public List<Block> blocks = new LinkedList<>();
    public boolean genesisAdd = true;

    public BlockChain() {
        Block genesisBlock = new Block("0000");
        blocks.add(genesisBlock);
        genesisAdd = false;
    }

    public String createTransaction(User sender, User getter, int amount) {
        if (sender.getBalance() >= amount) {
            sender.reduceBalance(amount);
            getter.addBalance(amount);
            return sender.getName() + " > " + amount + "$ > " + getter.getName();
        }
        return null;
    }

    public boolean addBlockAndCreateTransaction(User sender, User getter, int amount) {
        String trans = createTransaction(sender, getter, amount);
        if (trans != null) {
            Block block = new Block(getLastHash(), trans, BlockType.CONSUMPTION);
            Block block2 = new Block(block.hash, getLastHash(), trans, BlockType.INCOME);
            sender.userBlockChain.addBlock(block);
            getter.userBlockChain.addBlock(block2);

            return true;
        } else {
            return false;
        }
    }

    public void addBlock(Block block) {
        blocks.add(block);
    }

    public String getLastHash() {
        return blocks.get(blocks.size() - 1).getHash();
    }

    public List<Block> getBlocks() {
        return blocks;
    }

    @Override
    public String toString() {
        return "BlockChain{" +
                "blocks=" + blocks +
                '}';
    }
}
