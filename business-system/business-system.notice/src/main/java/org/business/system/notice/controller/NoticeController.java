package org.business.system.notice.controller;

import java.util.List;

import org.business.system.common.model.Notice;
import org.business.system.common.response.ResponseMessage;
import org.business.system.notice.model.dto.NoticeDto;
import org.business.system.notice.service.NoticeService;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;


@RestController
@RequestMapping("/manager")
//@Api(tags="{API}")
public class NoticeController {
	
	@Autowired
    private NoticeService noticeService;
	
    @Autowired
    private AmqpTemplate rabbitTemplate;
    
    
	@ApiOperation(value="获取消息详情", notes="根据消息的唯一id来获取消息内容" )
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "图书ID", required = true, dataType = "Long",paramType = "path"),
          //  @ApiImplicitParam(name = "book", value = "图书实体book", required = true, dataType = "Book")
    })
    @RequestMapping(value="/{id}", method= RequestMethod.GET)
    public Notice putUser(@PathVariable(name="id") Long id) { //@RequestBody Book book
		try {
			if(id==1) {
				noticeService.findNoticeDetailById(id);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
//        return noticeService.findNoticeDetailById(id);
    }
	
	
	@ApiOperation(value="消息推送", notes="推送notice对象" )
	@ApiImplicitParams({
		@ApiImplicitParam(name="notice", value="notice实体",required = true,dataType="Notice")
	})
	@RequestMapping(value ="/push", method = RequestMethod.POST)
	public String sendMessage(Notice notice) {
		noticeService.insertEntity(notice);
		noticeService.saveSelective(notice);
		return "seccess";
	}
	
	@ApiOperation(value="消息发送测试", notes="消息发送测试" )
	@ApiImplicitParams({
		@ApiImplicitParam(name="message", value="notice实体",required = true,paramType = "query")
	})
	@RequestMapping(value ="/test", method = RequestMethod.POST)
	public String test(String message) {

		this.rabbitTemplate.convertAndSend("hello", message);
		return "success";
	}
	
	@ApiOperation(value="消息列表", notes="消息列表" )
	@ApiImplicitParams({
        @ApiImplicitParam(name = "noticeSelectDto", value = "用户查询对象", required = false, dataType = "NoticeDto"),
        @ApiImplicitParam(name = "pageNum", value = "第几页", required = true, dataType = "Integer",paramType = "query"),
        @ApiImplicitParam(name = "pageSize", value = "每页数量", required = false, dataType = "Integer",paramType = "query"),
        @ApiImplicitParam(name = "orderBy", value = "排序", required = false, dataType = "String",paramType = "query"),
	})
	@RequestMapping(value ="/list", method = RequestMethod.POST)
	public ResponseMessage<PageInfo<NoticeDto>> noticeList(
    		@RequestBody NoticeDto noticeSelectDto,
		    @RequestParam(name="pageNum") Integer pageNum,
		    @RequestParam(name="pageSize",defaultValue="10") Integer pageSize,
		    @RequestParam(name="orderBy",defaultValue="create_date") String orderBy
			) {
		PageHelper.startPage(pageNum, pageSize, orderBy);
		List<NoticeDto> noticeDtoLiist = noticeService.getNoticeListByDao(noticeSelectDto);
		PageInfo<NoticeDto> pageInfo = new PageInfo<>(noticeDtoLiist);
		return ResponseMessage.success(pageInfo);
	}
	
	
	@ApiOperation(value="消息列表标记已读", notes="消息列表标记已读" )
	@ApiImplicitParams({
        @ApiImplicitParam(name = "ids", value = "标记ID数据", required = false, dataType = "Long"),
	})
	@RequestMapping(value ="/signRead", method = RequestMethod.POST)
	public ResponseMessage signRead(@RequestParam(name="ids") Long ids[]) {
		noticeService.signRead(ids);
		return ResponseMessage.success();
	}
	
	
	
}
