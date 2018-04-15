/**
 *
 */
package com.common.misc;

/**
 * 商品管理アプリに関連する列挙型クラスです。
 */
public class ItemEnum {

    public enum DeletedFlg {
        OFF(0), ON(1);
        private final int id;

        /**
         * コンストラクタ
         *
         * @param id
         */
        private DeletedFlg(final int id) {
            this.id = id;
        }

        /**
         * id から、削除フラグを取得します。
         *
         * @param id 削除フラグのID
         * @return 削除フラグ
         */
        public static DeletedFlg valueOf(int id) {
            // 列挙したオブジェクトからidが一致するものを探す
            for (DeletedFlg num : values()) {
                if (num.getId() == id) {
                    return num;
                }
            }
            // 例外
            throw new IllegalArgumentException("no such enum object for the id: " + id);
        }

        /**
         * 削除フラグのIDを取得します。
         *
         * @return 削除フラグID
         */
        public int getId() {
            return id;
        }
    }
}
