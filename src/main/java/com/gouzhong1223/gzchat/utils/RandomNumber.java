/*
 *              Copyright 2020 By Gouzhong1223
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package com.gouzhong1223.gzchat.utils;

import java.util.Random;

/**
 * @Author : Gouzhong
 * @Blog : www.gouzhong1223.com
 * @Description : 随机产生六位数字
 * @Date : create by QingSong in 2020-04-18 6:54 下午
 * @Email : gouzhong1223@gmail.com
 * @Since : JDK 1.8
 * @PackageName : org.gouzhong1223.cymmtj.util
 * @ProjectName : cymmtj
 * @Version : 1.0.0
 */
public class RandomNumber {
    public static Integer createNumber() {
        String integer = "";
        for (int i = 0; i < 6; i++) {
            integer += new Random().nextInt(10);
        }
        return Integer.valueOf(integer);
    }

    public static void main(String[] args) {
        System.out.println(createNumber());
    }
}
