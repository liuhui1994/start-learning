var baseUrl = location.origin + '/';//返回url中完整的协议和主机地址部分,包括端口
var userBaseUrl = "localhost:8084/newstart/";//用户中心基础URL
var noticeServerBaseUrl = "localhost:8081/notice/";//通知服务基础URL

//------------------------用户服务相关------------------------------
var userRegisterUrl = userBaseUrl + "user/register";//用户注册


//------------------------通知服务相关------------------------------
var sendMobileCode = noticeServerBaseUrl + "mobile/sendCode";//获取手机验证码
