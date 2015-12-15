package com.moqian.wenwu.hadoop.ch3;

import com.moqian.wenwu.hadoop.ch2.MaxTemperatureMapper;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mrunit.mapreduce.MapDriver;
import org.junit.Test;

import java.io.IOException;

/**
 * Created by xho on 12/14/2015.
 */
public class MaxTemperatureMapperTest {

    @Test
    public void processValidRecord() throws IOException, InterruptedException {
        Text value = new Text("0043011990999991950051518004+68750+023550FM-12+0382" +
                "99999V0203201N00261220001CN9999999N9-00111+99999999999");

        new MapDriver<LongWritable, Text, Text, IntWritable>()
                .withMapper(new MaxTemperatureMapper())
                .withInput(new LongWritable(0), value)
                .withOutput(new Text("1950"), new IntWritable(-11))
                .runTest();
    }
}
