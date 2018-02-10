/**
 * Copyright 2018 blockeeper
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package io.renren.modules.oss.cloud;

import io.renren.common.utils.DateUtils;
import org.apache.commons.lang.StringUtils;

import java.io.InputStream;
import java.util.Date;
import java.util.UUID;

/**
 * cloud storeage(支持七牛、阿里云、腾讯云、又拍云)
 * @author peng
 * @email yinpenghawk@gmail.com
 * @date 2017-03-25 14:58
 */
public abstract class CloudStorageService {
    /** cloud storeage配置信息 */
    CloudStorageConfig config;

    /**
     *  files 路径
     * @param prefix 前缀
     * @param suffix 后缀
     * @return 返回 upload 路径
     */
    public String getPath(String prefix, String suffix) {
        //生成uuid
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        // files 路径
        String path = DateUtils.format(new Date(), "yyyyMMdd") + "/" + uuid;

        if(StringUtils.isNotBlank(prefix)){
            path = prefix + "/" + path;
        }

        return path + suffix;
    }

    /**
     *  files  upload 
     * @param data     files 字节数组
     * @param path     files 路径，包含 files 名
     * @return        返回http地址
     */
    public abstract String upload(byte[] data, String path);

    /**
     *  files  upload 
     * @param data      files 字节数组
     * @param suffix   后缀
     * @return         返回http地址
     */
    public abstract String uploadSuffix(byte[] data, String suffix);

    /**
     *  files  upload 
     * @param inputStream   字节流
     * @param path           files 路径，包含 files 名
     * @return              返回http地址
     */
    public abstract String upload(InputStream inputStream, String path);

    /**
     *  files  upload 
     * @param inputStream  字节流
     * @param suffix       后缀
     * @return             返回http地址
     */
    public abstract String uploadSuffix(InputStream inputStream, String suffix);

}
