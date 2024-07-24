from django.shortcuts import render,redirect

def main_view(request):
    return render(request,"screens/main.html")

def main_redirect(request):
    return redirect('main')
