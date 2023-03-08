<%--
  Created by IntelliJ IDEA.
  User: ly
  Date: 2023/3/8
  Time: 14:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head><style>body {transition: opacity ease-in 0.2s; }
body[unresolved] {opacity: 0; display: block; overflow: hidden; position: relative; }
</style>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>403 - Mazer Admin Dashboard</title>
  <link rel="stylesheet" href="assets/css/main/app.css">
  <link rel="stylesheet" href="assets/css/pages/error.css">
  <link rel="shortcut icon" href="assets/images/logo/favicon.svg" type="image/x-icon">
  <link rel="shortcut icon" href="assets/images/logo/favicon.png" type="image/png">
  <style type="text/css">#_copy{align-items:center;background:#4494d5;border-radius:3px;color:#fff;cursor:pointer;display:flex;font-size:13px;height:30px;justify-content:center;position:absolute;width:60px;z-index:1000}#select-tooltip,#sfModal,.modal-backdrop,div[id^=reader-helper]{display:none!important}.modal-open{overflow:auto!important}._sf_adjust_body{padding-right:0!important}.super_copy_btns_div{position:fixed;width:154px;left:10px;top:45%;background:#e7f1ff;border:2px solid #4595d5;font-weight:600;border-radius:2px;font-family:-apple-system,BlinkMacSystemFont,Segoe UI,PingFang SC,Hiragino Sans GB,Microsoft YaHei,Helvetica Neue,Helvetica,Arial,sans-serif,Apple Color Emoji,Segoe UI Emoji,Segoe UI Symbol;z-index:5000}.super_copy_btns_logo{width:100%;background:#4595d5;text-align:center;font-size:12px;color:#e7f1ff;line-height:30px;height:30px}.super_copy_btns_btn{display:block;width:128px;height:28px;background:#7f5711;border-radius:4px;color:#fff;font-size:12px;border:0;outline:0;margin:8px auto;font-weight:700;cursor:pointer;opacity:.9}.super_copy_btns_btn:hover{opacity:.8}.super_copy_btns_btn:active{opacity:1}</style><style>[_nghost-dtv-c79]{height:100vh}.weava-ui-wrapper-new[_ngcontent-dtv-c79]{box-shadow:#0006 -1px 3px 60px;position:fixed;top:0;opacity:.99;left:initial;right:-580px;display:block;width:340px;min-width:auto;height:100vh;z-index:9999999999996!important;background:white;border:none;box-sizing:border-box;transition:1s}.weava-ui-wrapper-new[_ngcontent-dtv-c79] > *[_ngcontent-dtv-c79]{display:flex}.weava-ui-wrapper-new.show[_ngcontent-dtv-c79]{right:0;transition:1s}.weava-ui-wrapper-new.show.folder-show[_ngcontent-dtv-c79]{width:580px!important}ngb-toast.weava-notification-frame[_ngcontent-dtv-c79]{box-shadow:#0006 -1px 3px 45px!important;position:fixed!important;left:initial!important;top:20px!important;right:20px!important;width:300px!important;border-radius:4px!important;background-color:#142733!important;transition:all .3s ease!important;z-index:999}</style><style></style><style>#clipperButton[_ngcontent-dtv-c82]{font-size:30px!important;line-height:30px!important;width:30px!important;height:30px!important;text-align:center!important;z-index:2147483647!important;position:absolute!important;top:5px!important;right:5px!important;padding:0!important;background:midnightblue!important;color:#fff!important;border:none!important;outline:none!important;border-radius:50%!important}.weava-drop-area-wrapper[_ngcontent-dtv-c82]{position:fixed!important;z-index:2147483647!important;top:50%!important;width:70px!important;padding-left:10px;left:-10px;background-color:#142733!important;transition:left .2s!important;opacity:0;display:flex;flex-direction:column;justify-content:center}.weava-drop-area-wrapper.weava-drop-area-wrapper-show[_ngcontent-dtv-c82]{opacity:1}.weava-drop-area-wrapper.weava-drop-area-wrapper-drag-over[_ngcontent-dtv-c82]{left:0}.weava-drop-area[_ngcontent-dtv-c82]{display:inline-flex;justify-content:center;height:50px!important;background-color:#142733!important}.weava-drop-area[_ngcontent-dtv-c82] > img[_ngcontent-dtv-c82]{max-width:80%;margin:3px}.weava-drop-area-text[_ngcontent-dtv-c82]{font-weight:bold!important;padding:7px 0!important;text-align:center!important;background-color:#142733!important;color:#cbcbcb!important;font-size:10px!important}</style><style>[_nghost-dtv-c49]{width:340px;height:100vh}[_nghost-dtv-c49]   .login-c[_ngcontent-dtv-c49]   .login-main[_ngcontent-dtv-c49]   .logo[_ngcontent-dtv-c49]{width:60%;margin-top:40px}[_nghost-dtv-c49]   .login-c[_ngcontent-dtv-c49]   .login-main[_ngcontent-dtv-c49]   .title[_ngcontent-dtv-c49]{max-width:250px;color:#848484;font-family:"Lato","Helvetica Neue","Helvetica",sans-serif;font-size:18px;font-weight:400;line-height:24px;text-align:center;margin-top:24px}[_nghost-dtv-c49]   .login-c[_ngcontent-dtv-c49]   .login-main[_ngcontent-dtv-c49]   .login-btn[_ngcontent-dtv-c49]{width:60%;padding:10px 15px;border-radius:2px;border:1px solid #00b8c2;background:#00bfd2;color:#fff;font-size:14px;text-align:center;transition:all .1s ease-in;cursor:pointer;margin-top:58px}[_nghost-dtv-c49]   .login-c[_ngcontent-dtv-c49]   .login-main[_ngcontent-dtv-c49]   .login-btn[_ngcontent-dtv-c49]:hover{background:#01dccf;color:#fff}[_nghost-dtv-c49]   .login-c[_ngcontent-dtv-c49]   .login-main[_ngcontent-dtv-c49]   .login-btn[_ngcontent-dtv-c49]:active, [_nghost-dtv-c49]   .login-c[_ngcontent-dtv-c49]   .login-main[_ngcontent-dtv-c49]   .login-btn.active[_ngcontent-dtv-c49]{background:#617186;border-color:#617186}[_nghost-dtv-c49]   .login-c[_ngcontent-dtv-c49]   .login-loader[_ngcontent-dtv-c49]   .logo-wrap[_ngcontent-dtv-c49]{height:50%;max-height:200px}[_nghost-dtv-c49]   .login-c[_ngcontent-dtv-c49]   .login-loader[_ngcontent-dtv-c49]   .logo-wrap[_ngcontent-dtv-c49]   .logo[_ngcontent-dtv-c49]{width:50%}[_nghost-dtv-c49]   .login-c[_ngcontent-dtv-c49]   .login-loader[_ngcontent-dtv-c49]   .logo-wrap[_ngcontent-dtv-c49]   .loader[_ngcontent-dtv-c49]{width:40px;height:40px;margin-top:14px}[_nghost-dtv-c49]   .login-c[_ngcontent-dtv-c49]   .login-loader[_ngcontent-dtv-c49]   .login-actions[_ngcontent-dtv-c49]{height:50%;max-height:280px}[_nghost-dtv-c49]   .login-c[_ngcontent-dtv-c49]   .login-loader[_ngcontent-dtv-c49]   .login-actions[_ngcontent-dtv-c49]   .space[_ngcontent-dtv-c49]{margin:20px}</style></head>
<body class="vsc-initialized">
<script src="assets/js/initTheme.js"></script>
<div id="error">
  <div class="error-page container">
    <div class="col-md-8 col-12 offset-md-2">
      <div class="text-center">
        <img class="img-error" src="assets/images/samples/error-403.svg" alt="Not Found">
        <h1 class="error-title">Forbidden</h1>
        <p class="fs-5 text-gray-600">
          You are unauthorized to see this page.
        </p>
        <a href="index.html" class="btn btn-lg btn-outline-primary mt-3">Go Home</a>
      </div>
    </div>
  </div>
</div>


<div style="display: none" class="ubey-RecordingScreen-count-down ubey-RecordingScreen-count-down-container">
  <style>
    .ubey-RecordingScreen-count-down-container {
      position: fixed;
      height: 100vh;
      width: 100vw;
      top: 0;
      left: 0;
      z-index: 9999999999999;
      background-color: rgba(0, 0, 0, 0.2);
    }

    .ubey-RecordingScreen-count-down-content {
      position: absolute;
      display: flex;
      top: 50%;
      left: 50%;
      justify-content: center;
      align-items: center;
      color: white;
      height: 15em;
      width: 15em;
      transform: translate(-50%, -100%);
      background-color: rgba(0, 0, 0, 0.6);
      border-radius: 50%;
    }

    #ubey-RecordingScreen-count-count {
      font-size: 14em;
      transform: translateY(-2%);
    }
  </style>
  <div class="ubey-RecordingScreen-count-down-content">
    <span id="ubey-RecordingScreen-count-count"></span>
  </div>
</div><app-weava-root id="weava-root" class="weava" ng-version="12.2.16"></app-weava-root></body>
</html>
