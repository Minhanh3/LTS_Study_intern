### Công việc bắt đầu từ thứ 2 tới thứ 6 tuần tới: 8/7 -> 12/7

1. Đăng ký
2. Đăng nhập(sử dụng Json web token)
3. Quên mật khẩu(gửi mã xác nhận về email)
4. Xác nhận tạo mật khẩu mới
5. Đổi mật khẩu

### Công việc bắt đầu từ thứ 2 tới thứ 6 tuần tới: 15/7 -> 19/7
1. CRUD phòng ban: admin thực hiện
2. Thay đổi trưởng phòng: admin thực hiện
3. Chuyển phòng ban cho nhân viên: admin thực hiện
4. Tạo project: nhân viên có quyền employee và trong phòng ban sales thực hiện
5. Getalluser, getuserbyid

### Công việc bắt đầu từ thứ 2 tới thứ 6 tuần tới: 22/7 -> 26/7

Theo hình ảnh file thì sẽ có màn quản lý dự án. Tại màn này thì sẽ có phần bấm vào xem chi tiết của từng dự án, khi bấm vào đây sẽ có 4 cái step lần lượt là 
1. thiết kế dự án: tại đây những nhân viên trong phòng ban kỹ thuật có quyền design sẽ được quyền thêm thiết kế. Bắt buộc phải là leader của dự án đó mới được quyền duyệt một trong những thiết kế đã được đăng, khi thiết kế được duyệt thì sẽ không có designer nào có thể thêm được thiết kế cho dự án đó nữa. Khi thiết kế được duyệt hoặc từ chối phê duyệt thì sẽ gửi về thông báo cho designer đó là thiết kế đã được duyệt hoặc từ chối phê duyệt. Nếu được duyệt thì tiến độ của dự án sẽ là 25% 
2. Sau khi thiết kế được duyệt. Thì bản đó sẽ được xác nhận thông tin để in ấn dưới xưởng. Tiến độ 50%
Tại step này thì leader sẽ chọn những tài nguyên cho việc in ấn, trong trường hợp loại tài nguyên là văn phòng phẩm như: giấy thì khi dùng số lượng trong kho sẽ giảm, còn nếu là máy in thì số lượng giữ nguyên. Tiến độ lúc này lên 75%
3. Xác nhận hoàn thành in ấn: leader sẽ có phần xác nhận phần in ấn dự án đã hoàn thành và sẽ có email thông báo gửi về cho khách hàng thông qua email trong bảng customer. Tiến độ dự án lúc này là 100%
4. Step cuối thì trưởng phòng giao hàng sẽ chỉ định nhân viên giao hàng đi giao những đơn hàng bất kỳ làm sao tối ưu được việc nếu địa chỉ của các khách hàng gần nhau thì giao cho 1 shipper thôi. Nếu shipper giao hàng thành công thì sẽ có phần xác nhận giao hàng thành công đến từ phía shipper và thông báo gửi về email của khách hàng là đã giao hàng thành công. Một bản ghi thông báo sẽ được tạo và gửi cho leader của project và trưởng phòng ban giao hàng là đơn hàng được giao thành công . khi chọn phê duyệt thì sẽ hiển thị nút phê duyệt còn khi chọn không phê duyệt nó sẽ là nút không phê duyệt
