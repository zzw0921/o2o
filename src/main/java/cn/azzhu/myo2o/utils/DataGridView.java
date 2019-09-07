package cn.azzhu.myo2o.utils;

import lombok.Data;

import java.util.List;

/**
 * @author:azzw
 * @date 2019-9-4 19:49
 */

@Data
public class DataGridView<T> {

    private Integer code = 0;
    private String msg = "";
    private long count;
    private List<T> data;
}
