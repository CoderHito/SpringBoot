package com.hitol.springboot.test;

public class Main {

    /***
     * 下划线命名转为驼峰命名
     *
     * @param para
     *        下划线命名的字符串
     */

    public static String UnderlineToHump(String para) {
        StringBuilder result = new StringBuilder();
        String a[] = para.split("_");
        for (String s : a) {
            if (result.length() == 0) {
                result.append(s.toLowerCase());
            } else {
                result.append(s.substring(0, 1).toUpperCase());
                result.append(s.substring(1).toLowerCase());
            }
        }
        return "private String " + result.toString() + ";";
    }


    /***
     * 驼峰命名转为下划线命名
     *
     * @param para
     *        驼峰命名的字符串
     */

    public String HumpToUnderline(String para) {
        StringBuilder sb = new StringBuilder(para);
        int temp = 0;//定位
        for (int i = 0; i < para.length(); i++) {
            if (Character.isUpperCase(para.charAt(i))) {
                sb.insert(i + temp, "_");
                temp += 1;
            }
        }
        return sb.toString().toUpperCase();
    }

//    private static String s1 = "ds_mobile_check_match_ds_mobile";
//    private static String s2 = "ds_cid_check_match_ds_cid";
//    private static String s3 = "ds_realname_check_match_ds_realname";
//    private static String s4 = "ds_email_check_match_ds_email";
//    private static String s5 = "ds_area_check_match_ds_receiver_zone_max_12m";
//    private static String s6 = "ds_addr_check_match_ds_addr_used_max_12m";
//    private static String s7 = "ds_mobile_check_match_ds_mobile_used_max_12m";

    /**
     * "": "100",
     * "": "100",
     * "": "0",
     * "": "0",
     * "": "17",
     * "": "100"
     */

    private static String p1 = "ds_orders_success_sum_6m";
    private static String p2 = "ds_orders_success_sum_12m";
    private static String p3 = "ds_orders_time_3m";
    private static String p4 = "ds_orders_success_payment_12m";
    private static String p5 = "ds_orders_success_sum_3m";
    private static String p6 = "ds_goods_return_amount_monthly_average_12m";
    private static String p7 = "ds_orders_success_payment_proportion";
    private static String p8 = "ds_orders_success_max_payment";
    private static String p9 = "ds_orders_success_payment_6m";
    private static String p10 = "ds_orders_success_comparative_growth_base_proportion_3m";
    private static String p11 = "ds_orders_success_comparative_growth_base_proportion_6m";
    private static String p12 = "ds_orders_success_payment_3m";
    private static String p13 = "ds_orders_success_proportion";
    private static String p14 = "ds_realname_check";
    private static String p15 = "ds_cid_check";
    private static String p16 = "ds_realname";
    private static String p17 = "ds_cid";
    private static String p18 = "ds_account";
    private static String p19 = "ds_email";
    private static String p20 = "ds_mobile_check";
    private static String p21 = "ds_account_timeused";
    private static String p22 = "ds_mobile";


    public static void main(String[] args) {
//        System.out.println(UnderlineToHump(s1));
//        System.out.println(UnderlineToHump(s2));
//        System.out.println(UnderlineToHump(s3));
//        System.out.println(UnderlineToHump(s4));
//        System.out.println(UnderlineToHump(s5));
//        System.out.println(UnderlineToHump(s6));
//        System.out.println(UnderlineToHump(s7));


//        System.out.println(UnderlineToHump(p1));
//        System.out.println(UnderlineToHump(p2));
//        System.out.println(UnderlineToHump(p3));
//        System.out.println(UnderlineToHump(p4));
//        System.out.println(UnderlineToHump(p5));
//        System.out.println(UnderlineToHump(p6));
//        System.out.println(UnderlineToHump(p7));
//        System.out.println(UnderlineToHump(p8));
//        System.out.println(UnderlineToHump(p9));
//        System.out.println(UnderlineToHump(p10));
//        System.out.println(UnderlineToHump(p11));
//        System.out.println(UnderlineToHump(p12));
//        System.out.println(UnderlineToHump(p13));
//        System.out.println(UnderlineToHump(p14));
//        System.out.println(UnderlineToHump(p15));
//        System.out.println(UnderlineToHump(p16));
//        System.out.println(UnderlineToHump(p17));
//        System.out.println(UnderlineToHump(p18));
//        System.out.println(UnderlineToHump(p19));
//        System.out.println(UnderlineToHump(p20));
//        System.out.println(UnderlineToHump(p21));
//        System.out.println(UnderlineToHump(p22));

//        String s1 = "ds_realname_check_match_ds_realname";
//        String s2 = "ds_cid_check_match_ds_cid";
//        String s3 = "ds_mobile_check_match_ds_mobile_used_max_12m";
//        String s4 = "ds_orders_success_payment_3m";
//        String s5 = "ds_orders_success_payment_6m";
//        String s6 = "ds_orders_success_payment_12m";
//        String s7 = "ds_receiver_zone_max_3m";
//        String s8 = "ds_receiver_zone_max_6m";
//        String s9 = "ds_receiver_zone_max_12m";

//        System.out.println(s1.toUpperCase());
//        System.out.println(s2.toUpperCase());
//        System.out.println(s3.toUpperCase());
//        System.out.println(s4.toUpperCase());
//        System.out.println(s5.toUpperCase());
//        System.out.println(s6.toUpperCase());
//        System.out.println(s7.toUpperCase());
//        System.out.println(s8.toUpperCase());
//        System.out.println(s9.toUpperCase());
//
//        s1.replace("s","");

        String s1 = "credit_quota";
        String s2 = "consume_quota";
        String s3 = "jiebei_quota";
        String s4 = "zhima_point";
        String s5 = "available_quota";
        String s6 = "huabei_overdue_status";
        String s7 = "huabei_overdue_history";
        String s8 = "jiebei_available_quota";
        String s9 = "jiebei_valid_quota";
        String s10 = "jiebei_consume_quota";
        String s11 = "jiebei_overdue_status";
        String s12 = "jiebei_overdue_history";
//
//        System.out.println(UnderlineToHump(s1));
//        System.out.println(UnderlineToHump(s2));
//        System.out.println(UnderlineToHump(s3));
//        System.out.println(UnderlineToHump(s4));
//        System.out.println(UnderlineToHump(s5));
//        System.out.println(UnderlineToHump(s6));
//        System.out.println(UnderlineToHump(s7));
//        System.out.println(UnderlineToHump(s8));
//        System.out.println(UnderlineToHump(s9));
//        System.out.println(UnderlineToHump(s10));
//        System.out.println(UnderlineToHump(s11));
//        System.out.println(UnderlineToHump(s12));


        System.out.println(s1.toUpperCase());
        System.out.println(s2.toUpperCase());
        System.out.println(s3.toUpperCase());
        System.out.println(s4.toUpperCase());
        System.out.println(s5.toUpperCase());
        System.out.println(s6.toUpperCase());
        System.out.println(s7.toUpperCase());
        System.out.println(s8.toUpperCase());
        System.out.println(s9.toUpperCase());
        System.out.println(s10.toUpperCase());
        System.out.println(s11.toUpperCase());
        System.out.println(s12.toUpperCase());


    }

}
