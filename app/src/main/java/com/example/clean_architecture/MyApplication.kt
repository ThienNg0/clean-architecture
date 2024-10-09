package com.example.clean_architecture

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class MyApplication : Application() {
    // Có thể thêm cấu hình hoặc phương thức khởi tạo tại đây nếu cần
}
