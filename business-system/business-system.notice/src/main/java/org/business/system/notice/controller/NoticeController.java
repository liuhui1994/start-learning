package org.business.system.notice.controller;

import org.business.system.notice.model.Notice;
import org.business.system.notice.service.NoticeService;
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
    
    
	@ApiOperation(value="更新信息", notes="根据url的id来指定更新图书信息" )
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "图书ID", required = true, dataType = "Long",paramType = "path"),
          //  @ApiImplicitParam(name = "book", value = "图书实体book", required = true, dataType = "Book")
    })
    @RequestMapping(value="/{id}", method= RequestMethod.PUT)
    public Notice putUser(@PathVariable Long id) { //@RequestBody Book book
        return noticeService.findNoticeDetailById(id);
    }
}
