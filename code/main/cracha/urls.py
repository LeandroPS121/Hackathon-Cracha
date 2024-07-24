from cracha import views as v
from django.contrib import admin
from django.urls import path, include

urlpatterns = [
    path('', v.main_view, name="main"),
]
