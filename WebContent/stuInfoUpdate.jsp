<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>


    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>gradeManageSystem</title>

        <link rel="stylesheet" href="assets/css/main/app.css">
        <link rel="stylesheet" href="assets/css/main/app-dark.css">
        <link rel="shortcut icon" href="assets/images/logo/favicon.svg" type="image/x-icon">
        <link rel="shortcut icon" href="assets/images/logo/favicon.png" type="image/png">
        <link rel="stylesheet" href="assets/extensions/@fortawesome/fontawesome-free/css/all.min.css">

        <style type="text/css">/* Chart.js */
        @keyframes chartjs-render-animation{from{opacity:.99}to{opacity:1}}.chartjs-render-monitor{animation:chartjs-render-animation 1ms}.chartjs-size-monitor,.chartjs-size-monitor-expand,.chartjs-size-monitor-shrink{position:absolute;direction:ltr;left:0;top:0;right:0;bottom:0;overflow:hidden;pointer-events:none;visibility:hidden;z-index:-1}.chartjs-size-monitor-expand>div{position:absolute;width:1000000px;height:1000000px;left:0;top:0}.chartjs-size-monitor-shrink>div{position:absolute;width:200%;height:200%;left:0;top:0}</style></head>

    <body class="theme-light">
    <div id="app">
        <div id="sidebar" class="active">
            <div class="sidebar-wrapper active ps ps--active-y">
                <div class="sidebar-header position-relative">
                    <div class="d-flex justify-content-between align-items-center">
                        <div class="logo">
                            <a><img src="assets/images/logo/favicon.svg" alt="Logo" srcset=""></a>
                        </div>
                        <div class="theme-toggle d-flex gap-2  align-items-center mt-2">
                            <svg xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" aria-hidden="true" role="img" class="iconify iconify--system-uicons" width="20" height="20" preserveAspectRatio="xMidYMid meet" viewBox="0 0 21 21"><g fill="none" fill-rule="evenodd" stroke="currentColor" stroke-linecap="round" stroke-linejoin="round"><path d="M10.5 14.5c2.219 0 4-1.763 4-3.982a4.003 4.003 0 0 0-4-4.018c-2.219 0-4 1.781-4 4c0 2.219 1.781 4 4 4zM4.136 4.136L5.55 5.55m9.9 9.9l1.414 1.414M1.5 10.5h2m14 0h2M4.135 16.863L5.55 15.45m9.899-9.9l1.414-1.415M10.5 19.5v-2m0-14v-2" opacity=".3"></path><g transform="translate(-210 -1)"><path d="M220.5 2.5v2m6.5.5l-1.5 1.5"></path><circle cx="220.5" cy="11.5" r="4"></circle><path d="m214 5l1.5 1.5m5 14v-2m6.5-.5l-1.5-1.5M214 18l1.5-1.5m-4-5h2m14 0h2"></path></g></g></svg>
                            <div class="form-check form-switch fs-6">
                                <input class="form-check-input  me-0" type="checkbox" id="toggle-dark">
                                <label class="form-check-label"></label>
                            </div>
                            <svg xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" aria-hidden="true" role="img" class="iconify iconify--mdi" width="20" height="20" preserveAspectRatio="xMidYMid meet" viewBox="0 0 24 24"><path fill="currentColor" d="m17.75 4.09l-2.53 1.94l.91 3.06l-2.63-1.81l-2.63 1.81l.91-3.06l-2.53-1.94L12.44 4l1.06-3l1.06 3l3.19.09m3.5 6.91l-1.64 1.25l.59 1.98l-1.7-1.17l-1.7 1.17l.59-1.98L15.75 11l2.06-.05L18.5 9l.69 1.95l2.06.05m-2.28 4.95c.83-.08 1.72 1.1 1.19 1.85c-.32.45-.66.87-1.08 1.27C15.17 23 8.84 23 4.94 19.07c-3.91-3.9-3.91-10.24 0-14.14c.4-.4.82-.76 1.27-1.08c.75-.53 1.93.36 1.85 1.19c-.27 2.86.69 5.83 2.89 8.02a9.96 9.96 0 0 0 8.02 2.89m-1.64 2.02a12.08 12.08 0 0 1-7.8-3.47c-2.17-2.19-3.33-5-3.49-7.82c-2.81 3.14-2.7 7.96.31 10.98c3.02 3.01 7.84 3.12 10.98.31Z"></path></svg>
                        </div>
                        <div class="sidebar-toggler  x">
                            <a href="#" class="sidebar-hide d-xl-none d-block"><i class="bi bi-x bi-middle"></i></a>
                        </div>
                    </div>
                </div>
                <div class="sidebar-menu">
                    <ul class="menu">
                        <li class="sidebar-title">Menu</li>

                        <li class="sidebar-item ">
                            <a href="stuInfo" class="sidebar-link active">
                                <i class="bi bi-file-earmark-medical-fill"></i>
                                <span>个人信息</span>
                            </a>
                        </li>
                        <li class="sidebar-item ">
                            <a href="signUp.jsp" class="sidebar-link">
                                <i class="bi bi-pen-fill"></i>
                                <span>考试报名</span>

                            </a>
                        </li>

                        <li class="sidebar-item  ">
                            <a href="gradeSearch.jsp" class="sidebar-link">
                                <i class="bi bi-grid-fill"></i>
                                <span>成绩查询</span>
                            </a>
                        </li>

                        <li class="sidebar-item">
                            <a href="gradeSum.jsp" class="sidebar-link">
                                <i class="bi bi-bar-chart-fill"></i>
                                <span>成绩统计</span>
                            </a>
                        </li>

                        <li class="sidebar-item ">
                            <a href="login1.jsp" class="sidebar-link">
                                <i class="bi bi-backspace-fill"></i>
                                <span>退出</span>
                            </a>
                        </li>

                        <li class="sidebar-item  ">
                        </li>
                    </ul>
                </div>
                <div class="ps__rail-x" style="left: 0px; bottom: 0px;"><div class="ps__thumb-x" tabindex="0" style="left: 0px; width: 0px;"></div></div><div class="ps__rail-y" style="top: 0px; height: 789px; right: 0px;"><div class="ps__thumb-y" tabindex="0" style="top: 0px; height: 347px;"></div></div></div>
        </div>
        <div id="main">
            <header class="mb-3">
                <a href="#" class="burger-btn d-block d-xl-none">
                    <i class="bi bi-justify fs-3"></i>
                </a>
            </header>
            <div class ="page-heading">
                <div class="page-title">
                    <div class="row">
                        <div class="col-12 col-md-6 order-md-1 order-last">
                            <h3>个人信息修改</h3>
                            <p class="text-subtitle text-muted">请确认信息无误后输入</p>
                        </div>

                    </div>

                </div>
                <form action="updateStudent">
                <section class="section">
                    <div class="card">
                        <div class="card-header">
                            <h4 class="card-title">个人信息</h4>
                        </div>

                        <div class="card-body">
                            <div class="row">
                                <div class="col-md-6">
                                    <div class="form-group">
                                        <label >姓名</label>
                                        <input type="text" class="form-control" name="stuName" placeholder="输入姓名">
                                    </div>

                                    <div class="form-group">
                                        <label >学号</label>
                                        <input type="text" class="form-control" name="stuId" placeholder="输入学号">
                                    </div>
                                </div>
                                <div class="col-md-6">
                                    <div class="form-group">
                                        <label >专业</label>
                                        <input type="text" class="form-control" name="major" placeholder="输入专业">
                                    </div>
                                    <div class="form-group">
                                        <label>班级</label>
                                        <input type="text" class="form-control" name="stuClass" placeholder="输入班级">
                                    </div>
                                </div>
                                <div class="col-12 d-flex justify-content-end">
                                    <button type="submit"  class="btn btn-primary me-1 mb-1">
                                        提交
                                    </button>
                                    <button type="reset" class="btn btn-light-secondary me-1 mb-1">
                                        清除
                                    </button>
                                </div>
                            </div>
                        </div>
                    </div>
                </section>
                </form>
            </div>
        </div>

    </div>
    <script src="assets/js/bootstrap.js"></script>
    <script src="assets/js/app.js"></script>

    <script src="assets/extensions/chart.js/Chart.min.js"></script>
    <script src="assets/js/pages/ui-chartjs.js"></script>




    </body>
</html>