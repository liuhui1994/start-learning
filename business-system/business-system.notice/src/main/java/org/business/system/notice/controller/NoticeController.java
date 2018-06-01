package org.business.system.notice.controller;

import org.business.system.notice.model.Notice;
import org.business.system.notice.service.NoticeService;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;


@RestController
@RequestMapping("/notice")
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
        return noticeService.findNoticeDetailById(id);
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
	@RequestMapping(value ="/push", method = RequestMethod.POST)
	public String test(String message) {

		this.rabbitTemplate.convertAndSend("hello", message);
		return "success";
	}
	
}
