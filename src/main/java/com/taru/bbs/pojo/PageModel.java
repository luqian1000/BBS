package com.taru.bbs.pojo;
import java.util.List;
/**
 *分页对象
 * @author Administrator
 * @param <T>
 *
 * @param <T>
 */
public class PageModel<T> {
		private Integer  total;
		private Integer  pageSize=20;
		private List<T>  list;
		private Integer  page;   //pageNum
		private Integer totalPage;//总页数
		private String oldSql;
		
	
		public  PageModel(){}
		public  PageModel(String oldSql){
			this.oldSql=oldSql;
		}
		public PageModel(Integer  page,Integer  pageSize){
			this.page=page;
			this.pageSize=pageSize;
		}
		public  PageModel(String oldSql,Integer  page,Integer  pageSize){
			this.oldSql=oldSql;
			this.page=page;
			this.pageSize=pageSize;
		}
		public  PageModel(String oldSql,String  page,String  pageSize){
			this.oldSql=oldSql;
			this.page=Integer.valueOf(page);
			this.pageSize=Integer.valueOf(pageSize);
		}
		public PageModel(String  page,String  pageSize){
			this.page=Integer.valueOf(page);
			this.pageSize=Integer.valueOf(pageSize);
		}
		public  Integer   startRow(){
		     int  start =  (page-1)*pageSize+1;
		     return start;
		}
		public  Integer  endRow(){
			  int  end =  (page)*pageSize;
			    return end;
		}
		public List<T> getList() {
			return list;
		}
		public void setList(List<T> list) {
			this.list = list;
		};
		public Integer getPage() {
			return page;
		}
		public Integer getPageSize() {
			return pageSize;
		}
		public Integer getTotal() {
			return total;
		}
		
		public Integer getTotalPage() {
			Integer	_totalpage=total%pageSize==0?total/pageSize:total/pageSize+1;
			return _totalpage;
		}
		
		public void setPage(Integer page) {
			this.page = page;
		};
		
		public void setPage(String page) {
			this.page = Integer.valueOf(page);
		};
		
		public void setPageSize(Integer pageSize) {
			this.pageSize = pageSize;
		}
		
		public void setPageSize(String pageSize) {
			this.pageSize = Integer.valueOf(pageSize);
		}
		public void setTotal(Integer total) {
			this.total = total;
		}
		public void setTotalPage(Integer totalPage) {
			this.totalPage = totalPage;
		}
		public String getOldSql() {
			return oldSql;
		}
		public void setOldSql(String oldSql) {
			this.oldSql = oldSql;
		}
		
		public String  toCountSql(){
			StringBuilder  sb=new StringBuilder();
			sb.append(" select  count(*) as count from  ( ");
			sb.append(this.oldSql);
			sb.append(" ) _table");
			return sb.toString();
		}
		
		public String  toMysqlSql(){
			StringBuilder  sb=new StringBuilder();
			sb.append(" select * from ( ");
			sb.append(this.oldSql);
			sb.append(" )  _table limit ");			
			sb.append(startRow()-1);
			sb.append(",");
			sb.append(getPageSize());
			return sb.toString();
			
		}
	
		
}
