/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2011 All Rights Reserved.
 */
package com.alipay.demo;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * cardbin系统的数据初始化代码。
 * 
 * @author hongxin.xu
 * @version $Id: CardbinDataInit.java, v 0.1 2011-8-31 上午10:37:16 hongxin.xu Exp $
 */
public class CardbinDataInit {

    /** 目标路径(保存生成的数据初始化脚本)。 */
    private final static String DEST_PATH = "e://convert//poscore.csv";

    /** 保存cardbin系统的数据初始化脚本。 */
    private final static String SRC_PATH  = "e://convert//poscore.sql";

    /** 不需要读取的行标记。 */
    private final static String FLAG      = "ERROR_LINE";

    /** 空行标记。 */
    private final static String EMPTY     = "";

    /** 逗号。 */
    private final static String COMM      = ",";

    /** 需要插入的sql语句。 */
    private final static String INSERT    = "insert into sharedata.card_bin(card_bin_id, card_bin_value, card_len, card_type, card_alias, inst_id, domain, version, gmt_create, gmt_modified, operator, memo) values";

    /** 左括号 。 */
    private final static String LEFT      = "(";

    /** 右括号。 */
    private final static String RIGHT     = ")";

    /** 转义符单引号。 */
    private final static String SQ        = "\'";

    /** 转义符双引号。 */
    private final static String DQ        = "\"";

    /** 换行。 */
    private final static String ENTER     = "\n";

    /** 域信息。 */
    private final static String DOMAIN    = "FINANCE";

    /** 系统时间。 */
    private final static String TIME      = "SYSDATE";

    /** 操作员。 */
    private final static String OPERATOR  = "admin";

    /** 分号。 */
    private final static String SEMI      = ";";

    /** 版本信息。 */
    private final static String VERSION   = "1";

    /** 空格信息。 */
    private final static String BLANK     = " ";

    /**
     * @param args
     */
    public static void main(String[] args) {
        try {
            int startId = 2966;
            List<String> list = new ArrayList<String>();
            List<String> strList = readLine();
            System.out.println(strList.size());
            for (String str : strList) {
                List<String> splitResult = parseRecord(str, COMM);
                String result = constructor(splitResult, startId++);
                list.add(result);
            }
            writeFile(list);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 读取奇数行的数据。
     * 
     * @return 返回记录信息集合。
     * @throws Exception
     */
    public static List<String> readLine() throws Exception {
        // 保存返回结果。
        List<String> record = new ArrayList<String>();

        // 读取源文件流。
        InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(DEST_PATH));
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        // 定义计数器以及临时变量。
        String line = null;
        int totalCount = 0;

        // 读取数据。
        while ((line = bufferedReader.readLine()) != null) {
            // 从银联表中导入。
            // if (totalCount++ % 2 == 0) {
            // record.add(line);
            // } else {
            // continue;
            // }

            // poscore导入
            record.add(line);
        }

        bufferedReader.close();

        // 返回结果。
        return record;
    }

    /**
     * 解析输入的字符串。
     * <p>
     * 返回的结果顺序。
     * <ul>
     * <li>卡BIN值(0)。
     * <li>主账号(1)。
     * <li>卡长度(2)。
     * <li>卡别名(3)。
     * <li>卡类型(4)。
     * <li>机构名称(5)。
     * </ul>
     * </p>
     * 
     * @param record
     *        字符串。
     * @param split
     *        分隔符。
     * @return 分隔之后的结果。
     */
    public static List<String> parseRecord(String record, String split) {
        List<String> cardbinList = new ArrayList<String>();
        String[] splitResult = record.split(COMM);
        for (String str : splitResult) {
            cardbinList.add(str);
        }
        return cardbinList;
    }

    /**
     * 采用指定的参数构造sql语句。
     * 
     * @param params
     */
    public static String constructor(List<String> params, int startid) {
        StringBuilder builder = new StringBuilder();
        builder.append(INSERT);
        builder.append(LEFT);
        builder.append(Integer.toString(startid));
        builder.append(COMM);
        builder.append(BLANK + SQ + params.get(0) + SQ);
        builder.append(COMM);
        builder.append(BLANK + SQ + params.get(2) + SQ);
        builder.append(COMM);
        builder.append(BLANK + SQ + params.get(4) + SQ);
        builder.append(COMM);
        builder.append(BLANK + SQ + params.get(3) + SQ);
        builder.append(COMM);

        // 原银联bin表的数据直接转换过来后，会有冒号。
        String[] inst_arr = params.get(5).split(DQ);
        if (inst_arr.length != 0) {
            builder.append(BLANK + SQ + inst_arr[0] + SQ);
        }
        builder.append(COMM);
        builder.append(BLANK + SQ + DOMAIN + SQ);
        builder.append(COMM);
        builder.append(BLANK + VERSION);
        builder.append(COMM);
        builder.append(BLANK + TIME);
        builder.append(COMM);
        builder.append(BLANK + TIME);
        builder.append(COMM);
        builder.append(BLANK + SQ + OPERATOR + SQ);
        builder.append(COMM);
        builder.append(BLANK + SQ + EMPTY + SQ);
        builder.append(RIGHT);
        builder.append(SEMI);
        return builder.toString();
    }

    /**
     * 写入文件数据。
     * 
     * @param content
     *        文件内容。
     * @throws IOException
     */
    public static void writeFile(List<String> contents) throws IOException {
        FileWriter fileWriter = new FileWriter(SRC_PATH, true);
        for (String str : contents) {
            fileWriter.write(str);
            fileWriter.write(ENTER);
        }
        fileWriter.close();
    }
}
