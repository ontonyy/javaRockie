package com.ontony.blockchaininterface.blockchain;

import java.util.Objects;

public class Block {
    public String hash, prevHash;
    public String transaction;
    public BlockType type;

    public Block(String hash) {
        this.hash = hash;
    }

    public Block(String prevHash, String transaction, BlockType type) {
        this.prevHash = prevHash;
        this.transaction = transaction;
        this.hash = "0" + Math.abs(hashCode());
        this.type = type;
    }

    public Block(String hash, String prevHash, String transaction, BlockType type) {
        this.hash = hash;
        this.prevHash = prevHash;
        this.transaction = transaction;
        this.type = type;
    }

    public String getHash() {
        return hash;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Block block = (Block) o;
        return hash == block.hash && prevHash == block.prevHash && Objects.equals(transaction, block.transaction);
    }

    @Override
    public int hashCode() {
        return Objects.hash(hash, prevHash, transaction);
    }

    @Override
    public String toString() {
        return "Block" +
                "\nhash: " + hash + "\nprevHash: " + prevHash +
                "\ntransaction: " + transaction;
    }
}
