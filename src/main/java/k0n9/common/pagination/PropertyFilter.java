package k0n9.common.pagination;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import javax.servlet.http.HttpServletRequest;

/**
 * @author David Kong
 * @version 1.0
 */
public class PropertyFilter {
    private static final int DEFAULT_PAGE_ROWS = 20;

    public static Pageable buildPageableFromHttpRequest(HttpServletRequest request, int defaultRows) {
        return buildPageableFromHttpRequest(request, null, defaultRows);
    }

    public static Pageable buildPageableFromHttpRequest(HttpServletRequest request) {
        return buildPageableFromHttpRequest(request, null, DEFAULT_PAGE_ROWS);
    }

    public static Pageable buildPageableFromHttpRequest(HttpServletRequest request, Sort sort, int defaultRows) {
        int rows = defaultRows;
        String paramRows = request.getParameter("length");
        if (StringUtils.isNotBlank(paramRows)) {
            int pr = Integer.valueOf(paramRows);
            if (pr <= 0) {
                return null;
            } else {
                rows = pr;
            }
        }
        int page = 0;
        String strStart = request.getParameter("start");
        if (StringUtils.isNotBlank(strStart)) {
            int  offset = Integer.valueOf(strStart);
            page = offset / rows;
        } else {
            String strPage = request.getParameter("page");
            if (StringUtils.isNotBlank(strPage)) {
                page = Integer.valueOf(strPage);
            }
        }

        //if (sort == null) {
        //    sort = buildSortFromHttpRequest(request);
        //}
        return new PageRequest(page,rows, sort);
    }

    //public static Sort buildSortFromHttpRequest(HttpServletRequest request) {
    //    String sidx = StringUtils.isBlank(request.getParameter("sidx")) ? "id" : request.getParameter("sidx");
    //    Sort.Direction sord = "desc".equalsIgnoreCase(request.getParameter("sord")) ? Sort.Direction.DESC : Sort.Direction.ASC;
    //    Sort sort = null;
    //
    //    //按照逗号切分支持多属性排序
    //    for (String sidxItem : sidx.split(",")) {
    //        if (StringUtils.isNotBlank(sidxItem)) {
    //            //再按空格切分获取排序属性和排序方向
    //            String[] sidxItemWithOrder = sidxItem.trim().split(" ");
    //            String sortname = sidxItemWithOrder[0];
    //            //如果查询属性包含_OR_则取第一个作为排序属性
    //            //因此在写OR多属性查询时注意把排序属性写在最前面
    //            if (sortname.indexOf(OR_SEPARATOR) > -1) {
    //                sortname = StringUtils.substringBefore(sortname, OR_SEPARATOR);
    //            }
    //            //如果单个属性没有跟随排序方向，则取Grid组件传入的sord参数定义
    //            if (sidxItemWithOrder.length == 1) {
    //                if (sort == null) {
    //                    //初始化排序对象
    //                    sort = new Sort(sord, sortname);
    //                } else {
    //                    //and追加多个排序
    //                    sort = sort.and(new Sort(sord, sortname));
    //                }
    //            } else {
    //                //排序属性后面空格跟随排序方向定义
    //                String sortorder = sidxItemWithOrder[1];
    //                if (sort == null) {
    //                    sort = new Sort("desc".equalsIgnoreCase(sortorder) ? Sort.Direction.DESC : Sort.Direction.ASC, sortname);
    //                } else {
    //                    sort = sort.and(new Sort("desc".equalsIgnoreCase(sortorder) ? Sort.Direction.DESC : Sort.Direction.ASC, sortname));
    //                }
    //            }
    //        }
    //    }
    //    return sort;
    //}
}
