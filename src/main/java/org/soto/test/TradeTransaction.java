package org.soto.test;


import java.util.*;

/**
 * 不合法的交易
 *
 * @author: liuqixin
 * @created: 2021/11/24 19:37
 * @updated: 2021/11/24 19:37
 */
public class TradeTransaction {

    /**
     * 如果出现下述两种情况，交易可能无效：
     * 交易金额超过 ¥1000
     * 或者，它和另一个城市中同名的另一笔交易相隔不超过 60 分钟（包含 60 分钟整）
     * 每个交易字符串transactions[i]由一些用逗号分隔的值组成，这些值分别表示交易的名称，时间（以分钟计），金额以及城市。
     * 给你一份交易清单transactions，返回可能无效的交易列表。你可以按任何顺序返回答案。
     * 解答要求
     * 时间限制：1000ms, 内存限制：100MB
     * 示例1：
     * 输入：transactions = ["alice,20,800,mtv","alice,50,100,beijing"]
     * 输出：["alice,20,800,mtv","alice,50,100,beijing"]
     * 解释：第一笔交易是无效的，因为第二笔交易和它间隔不超过 60 分钟、名称相同且发生在不同的城市。同样，第二笔交易也是无效的。
     * 示例2：
     * 输入：transactions = ["alice,20,800,mtv","alice,50,1200,mtv"]
     * 输出：["alice,50,1200,mtv"]
     * 示例3：
     * 输入：transactions = ["alice,20,800,mtv","bob,50,1200,mtv"]
     * 输出：["bob,50,1200,mtv"]
     */
    public static void main(String[] args) {

        String[] transactions = {"alice,20,800,mtv", "alice,50,100,beijing"};
        // String[] transactions = {"alice,20,800,mtv","alice,50,1200,mtv"};
//        String[] transactions = {"alice,20,800,mtv", "bob,50,1200,mtv"};

        String[] errTransactions = getErrTransactions(transactions);

        for (int i = 0; i < errTransactions.length; i++) {
            System.out.println(errTransactions[i]);
        }
    }

    /**
     * 交易
     */
    static class Transaction {
        private int index = -1;
        private String transName;
        private Integer transTime;
        private Integer amount;
        private String city;

        public Transaction() {
        }

        /**
         * 是否超金额
         *
         * @return
         */
        public boolean overAmount() {
            return this.amount.compareTo(1000) >= 1;
        }

        /**
         * 是否违法
         *
         * @param anoTransaction
         * @return
         */
        public boolean illegal(Transaction anoTransaction) {
            if (!this.city.equals(anoTransaction.getCity())) {
                if (Math.abs(this.transTime - anoTransaction.getTransTime()) <= 60) {
                    return true;
                }
                return false;
            }
            return false;
        }

        public Transaction(int index, String transName, Integer transTime, Integer amount, String city) {
            this.index = index;
            this.transName = transName;
            this.transTime = transTime;
            this.amount = amount;
            this.city = city;
        }

        public Transaction(String transName, Integer transTime, Integer amount, String city) {
            this.transName = transName;
            this.transTime = transTime;
            this.amount = amount;
            this.city = city;
        }

        @Override
        public String toString() {
            return this.transName + "," + this.transTime + "," + this.amount + "," + this.city;
        }

        public String getTransName() {
            return transName;
        }

        public void setTransName(String transName) {
            this.transName = transName;
        }

        public Integer getTransTime() {
            return transTime;
        }

        public void setTransTime(Integer transTime) {
            this.transTime = transTime;
        }

        public Integer getAmount() {
            return amount;
        }

        public void setAmount(Integer amount) {
            this.amount = amount;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }
    }

    private static String[] getErrTransactions(String[] transactions) {
        int length = transactions.length;
        if (null == transactions || length == 0) {
            return new String[0];
        }
        Map<String, List<Transaction>> transactionMap = new HashMap<String, List<Transaction>>();
        // 标记违法交易
        boolean[] illegalFlg = new boolean[length];
        for (int i = 0; i < length; i++) {
            String[] split = transactions[i].split(",");
            Transaction transaction = new Transaction(
                    i, split[0], Integer.parseInt(split[1]), Integer.parseInt(split[2]), split[3]
            );
            // 超额标记
            if (transaction.overAmount()) {
                illegalFlg[i] = true;
            }
            String transName = transaction.getTransName();
            List<Transaction> transactions1 = transactionMap.get(transName);
            if (null == transactions1 || transactions1.size() == 0) {
                transactions1 = new ArrayList<Transaction>();
            } else {
                for (Transaction itemTrans : transactions1) {
                    // 违规标记
                    if (transaction.illegal(itemTrans)) {
                        illegalFlg[itemTrans.index] = true;
                        illegalFlg[i] = true;
                    }
                }
            }
            transactions1.add(transaction);
            transactionMap.put(transName, transactions1);
        }

        // 构建返回
        String[] strings = new String[length];
        int offset = 0;
        for (int i = 0; i < length; i++) {
            if (illegalFlg[i]) {
                strings[offset++] = transactions[i];
            }
        }
        return Arrays.copyOf(strings, offset);
    }


}
