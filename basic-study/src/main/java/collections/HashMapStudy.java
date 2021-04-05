package com.oseco.quick.collections;

public class HashMapStudy {
    static final int HASH_BITS = 0x7fffffff; // usable bits of normal node hash

    /**
     * Spreads (XORs) higher bits of hash to lower and also forces top
     * bit to 0. Because the table uses power-of-two masking, sets of
     * hashes that vary only in bits above the current mask will
     * always collide. (Among known examples are sets of Float keys
     * holding consecutive whole numbers in small tables.)  So we
     * apply a transform that spreads the impact of higher bits
     * downward. There is a tradeoff between speed, utility, and
     * quality of bit-spreading. Because many common sets of hashes
     * are already reasonably distributed (so don't benefit from
     * spreading), and because we use trees to handle large sets of
     * collisions in bins, we just XOR some shifted bits in the
     * cheapest possible way to reduce systematic lossage, as well as
     * to incorporate impact of the highest bits that would otherwise
     * never be used in index calculations because of table bounds.
     */
    static final int spread(int h) {
        return (h ^ (h >>> 16)) & HASH_BITS;
    }

    /**
     * Computes key.hashCode() and spreads (XORs) higher bits of hash
     * to lower.  Because the table uses power-of-two masking, sets of
     * hashes that vary only in bits above the current mask will
     * always collide. (Among known examples are sets of Float keys
     * holding consecutive whole numbers in small tables.)  So we
     * apply a transform that spreads the impact of higher bits
     * downward. There is a tradeoff between speed, utility, and
     * quality of bit-spreading. Because many common sets of hashes
     * are already reasonably distributed (so don't benefit from
     * spreading), and because we use trees to handle large sets of
     * collisions in bins, we just XOR some shifted bits in the
     * cheapest possible way to reduce systematic lossage, as well as
     * to incorporate impact of the highest bits that would otherwise
     * never be used in index calculations because of table bounds.
     */
    static final int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }

    /**
     * 1. spread:原值右移16位，原值再与高16位进行异或运算，再与2147483647进行与运算
     * 好处：让生成的值相对均衡，降低冲突概率
     *
     * HelloWorld
     * original: 11010001011111010001000000000
     * spread:   11010001011111011100000101111
     * hash:     11010001011111011100000101111
     * <p>
     * TestYourSister
     * original: 11110110001010100100001010001001
     * spread:   1110110001010101011010010100011
     * hash:     11110110001010101011010010100011
     * <p>
     * JiLiGuaLa
     * original: 11100010110010010001100000101100
     * spread:   1100010110010011111101011100101
     * hash:     11100010110010011111101011100101
     */
    static final void testHashAndSpread() {
        System.out.println(HASH_BITS);
        System.out.println(Integer.toBinaryString(HASH_BITS));
        int hashCode = "HelloWorld".hashCode();
        System.out.println(hashCode);
        System.out.println(Integer.toBinaryString(hashCode));
        int _hashCode = spread(hashCode);
        System.out.println(_hashCode);
        System.out.println(Integer.toBinaryString(_hashCode));
        _hashCode = hash(hashCode);
        System.out.println(_hashCode);
        System.out.println(Integer.toBinaryString(_hashCode));
    }

    public static void main(String[] args) {
        testHashAndSpread();
    }
}
