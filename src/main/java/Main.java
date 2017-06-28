import static org.apache.hadoop.hbase.util.Bytes.toBytes;

import java.io.IOException;
import java.util.ArrayList;

import org.apache.hadoop.hbase.filter.CompareFilter.CompareOp;
import org.apache.hadoop.hbase.filter.Filter;
import org.apache.hadoop.hbase.filter.FilterList;
import org.apache.hadoop.hbase.filter.FilterList.Operator;
import org.apache.hadoop.hbase.filter.SingleColumnValueFilter;

public class Main {

    public static void main(String[] args) throws IOException {
        ArrayList<Filter> rowFilters = new ArrayList<Filter>();
        SingleColumnValueFilter filter =
                new SingleColumnValueFilter(toBytes("test"), toBytes("test"), CompareOp.NO_OP, toBytes("testg"));
        rowFilters.add(filter);
        new FilterList(Operator.MUST_PASS_ALL, rowFilters).toByteArray();
    }
}
