# MVVM 패턴이란 무엇일까? 🤔

 
#### 이 MarkDown 는 [To-Do App & Clean Architecture -Android Development - Kotlin](https://www.udemy.com/course/to-do-app-clean-architecture-android-development-kotlin/#instructor-1) 강의를 참고하여 만들었습니다.



  # MVVM 패턴이란 무엇인가? 😀
  <h2>**MVVM** 이란  **View** **ViewModel** **Model** 이 결합된 형태로, 각각의 역할을 분리하여, 가독성과 재사용성을 높인 디자인 패턴이다 </h2>

  
<br>

> MVC와 MVVM의 차이점..
 ![image](http:// data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAQMAAADCCAMAAAB6zFdcAAABCFBMVEX////13Xl5yPX7+/sAAAC0tLT022724Yr++/BxxfX9+uyampro9f2u3PjP6vuP0Pb234T78tCZmZmioqL74nzx8fHm5ubY2NimpqbHx8fs7Oy6urqIiIj5/P58zfu+4/r57bzd3d23t7dbW1vPz88oKCiFhYWyoFeQkJB9fX2/rF7Dw8Nzc3PUv2jx2XdaWlptbW1Mf5yOgEVKSkrDsGCai0torNPTvmiBdD+qmVOPgUY7OzsxUmVVja1XTin/7YLizG8YGBhencBQhaNtYjVWTSkkJCQVFRVss9wmQE8/aoI9Zn4YKjQ+Pj702WMcGQxEPSIQHiUtTF4NFx0eM0AyLRc5Mxz56rGCjFnPAAAWJklEQVR4nO2diWOiSLrAywDzdpd5O/O4r/UthsjlgQoqdjSM0Z4c3dOZ3ul+//9/8qoAFdGoXDk6+dKteMBX/Kj6jqKqBNi7AAy8dXln8M4AyQtgoD13AV4AA+K5C5BkIPE8u9nEMJ6PX7E8Fz7zBGGzoGxJMuCg3nhThepZXl0XiNsqjrp+ldzMJ0kGJo43480LHBd5HJdWH3Tho4CHcl42hSSDAY4L8SZUJRE4vv4AfhRdCdCExYGf2tErFm4WK1KSgYKvVHJwSwQfV+XBcRkAB8cvTOUcx+lCCnclyQAefhBtiTg6Z1QMJPBEuYuV5t9gceBFcqJXQukMIgNFhQyacXlghcDQWyER6YIspHBXUgziq+2EW13cDF818AtgxMVRUXEgAzwq+aB0Bq1w62PIgI8PbkDk7Pr6Y1IhhbuSZhDqwfCQwaoxnOMGOve4ON2wsaLKGVXZUhk4kUoevzhHlRDHw/KhuiesW2YBXaomxtY1KdsMHHjFocj4YAAZQPTI4EEiKipH+NULvIEenNBIARJvncjgEfVpBsLn0NIouNFCDBT8HMR1z4krZW5hCZIQVY63aSH1yTYDOTxd2AiID6hVdGEFAMAOr4ASnjUXnvIFbkenfoFrpzCQkHoOqd91xdsMaCE8699x1UEMtLDNkei9AZ4ueibhqMa6nKyxXeRtBqKJzhpeeCxkQOAf4dstXAGxXQJ0SOIC57qoWsALBI4z4Ch5fZpp9WkGJIvUaFBv2BZA6IA+oIZ3gRcJZYTG1ktyqxTbDGwe/x0Z+y46zdAhqKgcYQjwOyrJ57AkF7gqIxtpwPp5lIEgb72kUl9PMYDXmwDoSkQMmtBGSiH9AV7AHeyQp5IvUm0BNnseqpMjBrAxkPCi/BYX0EHFiZoAj6H45TfoyY4wwA6r32VAhPEHFzOAjSG8JKg2OkdP9TExdt5RkzlCmoGCN9nI/SEGBP4BXpQodkPFISJTCBlAGyWoiM4RBrvq+e0UJc0AakdaYwaoEg7Cukfk9wvCnowkWanSDFT8I42IRwxggdjf8Tga/h3XuivnwMMwaqAg43GYAX1E/S6DMDYR1gxM5C7RN7B1HK1ljBMlec+byRA/zSD0/eKKAWwWTtwUUNt04hNGDEAUQxxmwNl73tTU5KsdBjYepgkxA1j7orqHAgQTvo/RWZ1kkjnL2XbkoRMgdxjQUcweM0Cx8CqNgZ4hDhZDBjDBQcHEQQZH1acZUOERu2DNAKGOy2jAzd8+4lnzBVgNJIKmQ/CtlihJooE0EptiJxl0EQMpOumYgbSO4KPiRD76I2LAR4U5xIATQ/XhkRwzVB/qTDaQJAMjPKKJwjDgxAzMjQLYFFGtyNjlIQDJhEeQ4W5UpIpFJ41tzjzlGwGq/qipxAxQQrD+fF2cizCS+i3MbA8xEACH1BPa2huE6rca6FYfCrbzuC2YlD1XEOLaSK71RtVxU5u2Ao/HlafLkk09jWpEKHJKfWX9SOsLo/KxW6CBKoZvq0RcuJVU0I+0Vs+rsR4aOcRQvZxSXxkDmYxrTAOjV4WAThJWai3WvmmRFTBorCJRAlszwIhQPZFWX2F/IhEpF1DDNzhUCYBIywS5MidilQzgQePaxsowTpTCqMhOqpcTrbq6PlUptP80ugIXnBS1SmmjrGIGsXoB/rEfOE5Iqy+bgQo0lmU5gGEaxnEaprJxbxRADMQGywm751leW+CRegmqZ6HqlHoB2PIR9aUwIOiGwbdkWTIME3MUA+vKmxAdXgBO1jAUXm471Uf8QnYRSNngHVmUSMPAWiaFDcS96rc7n0v2CwZLUaDVtNmmYgrnLYemnE0hxLjjBhZhK29I1MWCDBSMhOpNDapv0lA9SZ5v8sLVrQAqpb6RdPIlMOBMyaBYroEZDRMQ4gBzjE04vYqF4AWREpE7lvBNBRlwLdagMNWG6g1Ay+eYaSjrD1l5rT6Zq7JbHULl2EQYWUpaqIoHMrBBIgqj14XAEh0pyQy+uE1soJsz4bMGVYtJ9eRaPZt4dzudrvxeW5yrC2AdqEGxk3lbpffatLX6RD2Qt3tWq2KAcasbd3T4BO3CpkdR2jrtKhjsqJcS6rmUxooYSIKtrZJ02kYqyE0Wy21nnhUw4BLqSTuKU9bq1XTv8FPcd0Y5Izzx9c3UVBmqvu9MIFOhrrmrO/qegkGqw6GZ+rhqBkfUPwkDLHWS6eZYMQM2dXx1p2/vCRjI6R6OxnYvRMUMiPQJEunyVMxAs3fqIkh361bIQBOPq6+aAYrH0k0BbALoSKpjIO1Xb6d6w6plgOKx7X7sSLauTWkMdnoVQ/V77jSnHFOlDMJO1H2nuFWIshhgVGpcEoWlVe1TXy0DYqf3ciVaFbEyS25n58Jp6ktjIO7pcbej9/YVIpm/lMaA264HMv/o0aXte08lMSB2q5wdp0h7xy0k3yyLgUolm74cXYF0dBAKtl2myhhwq5qx97ZUFQw0MmHvD6pP+Yrq6sG6NEf3LaMAUERy36kcVV8aA7nAoMWyGAh5RwuVZRP3XoPTpCQGGCUe/9L+PX8YBlw6PDhZSmsLz85AIw+OyDkg1dvE4/uWUQB0myPvniUx2HMn52QphwFG7ht0c9qu5TCg9w06OlHKYSDlNgclMUiH6pmkBAaCBjQKRkgaC3g+8ziRchgUuAilMCDI0By0jBYwqMwDq8thwFF7OglOlRIYqKQGW6PWdUyYqSnHv78t5TDgqQKTGkpggJECyfHkTk/hiXuXwqBIeFAKA5oWRHLfgNiT9i6FQRHXWIpfgAzInQ7kU6UcBkVcYykMCDp/eFAOA5YqMle1DAZso4BRLoXBdg9OVnlR81xzi5aeGZJJfgwGRXpQfhQGhdzCj8EAI/P24IRyOoOf/zur/OuUw5bBoFC2kIXBP/+eVX4+5bCFGWBF3UImBmfZ5GkYsKQKxLAXi4YJm6LsjvI4KkUY1OG/+vMzsGO3MBBbgBJyzAguwODmrn52f4swRH/PwwDl7WFPHkaGUylztIoCDOp/1ue9Ofx/Mz+DfzsQnoiBRmENxIAn8xrGIgzuhpdnn+aX88vbOY4qxfMw4EgetQV2Zzr7yVLEHgzvb+t/9S7vpveXva/D52IAaBsykGgydy9KIZuI9+p/Dr/Op9PbM3zHHDwZA0JoCFI8gzDfAU7+5h7fODyrD+vD6c3ZTX34fAxsQSAE+kn60h6NDx5zj0/FQKNpmnya3PmFxkgoQiiG4EdgADi7EIIfgsFpgj3azfJWGGD24wutvREG4qEOhnwM6pv84PGs6eUw4OSDOnIxqPem9U/w3GGOUO+hRGE4r9dv5qlQ8cUwkI70MuVk0Lu5velN51/vzuBmr3d33YMbd3dn03p1DP71c1Y58cB568Fdbz69nvZuru/vYbY0v57fDafzaa/KevC/mTuyTurMy8vg+qw3vYb1YHpzWb/p3c3vemf3N/P7s8t6pQwOmuA9BqlKBqjLJJKoLynaqNenW1lDhQzqu5Z4z1vVMnhMtopRHYP69PYydEjwxG8i/Gdfr+fhO8/OYPsyVMWgPr89G97M5/XhfHjzn+FwfgMr4OV0/vfpGXROexhwqqpKj6t5RX3rGwb3w3r9+u5u+p/e7fzT8M/rr9PLOWRwO7+9+7qXgSRxB9a+zXCP5Z9ZpeR7LNsMbs/OLm/r0Ef/8umXT/Xh3eX07q/7y7tkjFJ+W6hI8tiD4adh7+v19fVf9bvhp5tP9cv5PawH09sb6KErtQePCaYVCvRy2cTh3bR+fV2f1odn0ykMVGHcCk3D8A4+7GXQaBCA1ARMEDQgqrKk0TZHrxYJKoFBwRtd+eKDen2Vs9Qj/xBvbxvlNQNFMAzboADLGsBxCMH80JU14KzWMDpJPW1oIklSQJYIQjQF2hEozWw2VTQE51kYnCSIQVhEYBqURioU0AgNtJoCTwiUKIirW1KnMVBkgQfdLqCbwrlIO7TZcETFHISzl/n8ndpIqo4Tw3lFKkcCjYVVAdYFTm1otECLGrcaS3kaA9O0RQdTgKAIAu+YAnHe1SizKSF/U2T2BHiCWDlyihzY3IZjY42r16cxwDBRxICCOqRoYEqCMuhiEt0KGaMbXVj+QVnV5wv75vpuSTGbqKrRsr1q/jFRT5AzaavwCGvINvyTU433NAY2psgUYcA2JTZsUiaocNVkEtoHzTZbFHbu0FiTlG0q+02/nH5hkxk8fvd/7RfWEMQGbNFE+pxPtIngg4YZLZY2hZZKKISgKIA9bwH+83mThham2xW4lkOAVivzALF8eeNlfdir1+fIM17C/8MzmDDNb1K548Y38nFPksqTgNDS4zlPY9ClHLHFtgCNpEs3FYG2HckErNMVBFOhSY1WHUeRieYTMfg67PWm9/P5XW/YG05h2tAbzqeX8GE/AyAdsgmnMWBZh2BBC63lScNKITQ1kWNBEwitgdMdDGjK6XKfz2kVmNTxg21LPga9HgyV76+vb657UH7p1eHz9Bq+XWXujPxJaEpY9MdyyK9I4V1/6GrRp5iqotXJM9vGvAyGvfvL6+uz3h3i0ZvCkPl6GsbN1TF4dP8i47WRFIiV63HEvOnVuttvE49IUQbYvoUHMh3gNfUnViTvDN4ZIDmdwT9/ySqlM8D+llVOO+xT3Xt/XE5n8D9//JRN/vjHKYd9XQx+qmWTn56FAZb9cDkYMOG/lTAM+hdK0Fk9PCODHDMdszMIFkxnsQzPHf0tLWb0jUEYGN+Cz57FVMtAPNx1p5KZp/llZ8B8Y3RPZ/RxoNf8mv4wuxp/YbxxJxgv3PbY9StmQBybryGTWTt0cjCYuIvgwVq4s+UIb/dny85yoU9Gi2Uws761v1VcD+Tj03aErGty5LAHwWJ5tZwsJvp46S9HS2vmL/qjq++zK8/7PvEqZYARJ2QnEpmxIyePTcS9q++jpe7rDzWc+V7DO5DExFt4X9wHvV9lW+DokyZv8RkX6cnjG4MO02YCq9MJ4DPcQn8uU3PbnZoVVOgXbOrEgdmNbFN/88cHTPoVk3qzZAYYQR0eXpYQIpNdfDUxkiRkWPIEE7Lc+HktDFQy0wQFlqZPdw6vhAFPCtkcHpdhUsfrYKBlX2NCojfTOrjD/F4YA5nnWZHVACeznCTJGA80oKpEk7S5rNFfAsKenw9NSo44scZ01luhHwhqtU4Hbm/cYl4G3EWXamgfTNCSB3KLvCBIypA+D5pdpWW3Ti5pLNLaJuzcWdqWzAxGOjMeRS7wC+NPEAf40HZrY38MA4diDDCzaZBkswlshZNp44PBGZT02bGbymcx28948mpDlZUmZ3M20BxDhG9IjUcirMwMYLrg6v3xRHe9Rbvv9/u6N/a9/kgPGH3kT8buYhUo5mDAd00T0Kj+txSbVi74Jm80uw4hEI6dLQB2tBZBmU6L5E2ADQYk3xRVerD7i5pIsjPw+h1IwPP6lj/W+3rwcOUtLG9kjRhd1z3LH03yM4AiAtoggGRQKhDPYYM2SR59Q977w8iPS0tsCYRBOuc2hKqcw+DCEJpOc69RyW4P2l7Hnfht1w8sr6N7k/ZkYnmQgOd5kIzne14hBgkRCBTs5Bva0JBbIiEK9nlLAdhFU9BEHnPo/T8Jm6sfiYk6j8J/sdQ2m2XlTGhtThlNYuaIPKsfoaEXGuBpA/10JSsJAisT+5POF+YbkyKSrAZ9ok1TuWdzAxBSFA4zfMEMaEIiaQiAKDIAEkNdKkcWGn25DFiSoGma4At1uYqUINNE4/CoiAwMar9mk1oxBjxNk1qRpZ+QSCJBoqnAB7PIl3uvrUHKBZYg24hkC+ThtLukNWXTv66RYdfHGHCF1vvZEkktaW7ffgmbKybQuRfve1X32jgJ/RYnBjjAShJ8wFhOlTAKuVyRFmiycfQIe+UVMYCxJ2GaRMPkFaB2m01MUcXGRyVcqUwiGwQh5lzV9RUxMDRHgCK35C6QZcFQDIHuDs555HoJmoXZac41WV4TA7JFGAZhK6QJ2CZFqRzHU3QTrXOOkTJoCIeHAD4uCQa//lc2+fXfieP8O/PemRlES5aiX/2C8YZC2VxL4QzDDNd6lzBgl7HeeuYgLMng/zLvnYPBfolXLhTLWHd/71kw+97cx+DA6TL7DlQig8gd5F/j+QCDThtm6lZOBkG7xozizj2UzXe8FITyGIRxgQTU3Gt9H2Lw5SpY+mFSHo51yMKA0XGmhltRlv8AnzrLqhiEK1g2KCz/4r4HGDCzwLOWtdmDP+t86yx2IBxh0Lbw0Xi56Dw8zNrL7+1ZJQw4LVzrXaTEAj/AcIiB7i8ZCMB7WPjf9HRdPsbAGy/G+uxqvHA7s1l/MU4zLIdBg5J5UuJIdAxoG1VOha2CAxjHwiDyVK9/0CZ+WVw9+F4n8L608fbOpwcZ+NZy4evLq8XCDWazdtCuqC3YMEZm6XAQVIPGqNYAOEABptBUZaNbAgNmYTGz2mzmtcfMww6CI/XA9S1/5C3HnYflOFguR+NqGLAkTdjRGlUirTb5loAmEQqfSdo0Tr0dcLAeRMbwEZN42C+sej03fZ7pvcthAARYEaKEUSMlgXQAjBgBKRK8cH5+orMsLUbKuHNpDHiSjIMjjcJsygBNRQBa01BhKH1i0PTqGQCWiy83lnfC76tiUP2Y7ZfPoPox26+AwZ4xWbGtDW3uruEtyuDRdGl1M+8QAyaxsesUymHAWEGt40ebustED6UwCG/ioXTHjYoe+Te3s3rBdOI7248zGHUYC+01ChhGZzr6yNr1r2UweBijvKQDtXQ8nQkY+FAKg7bPuPrCdZmRBUOkUa1muVZgWe223mZcxrVGVuAfYcCM9eABXiB3HOiBx4w7I9/V4aaeHCRSBoPFAzN7CGAo7y2+WIvxzC+HAeOOPb3jWV574nt622M6Y7hpzXSv3Wfas5E3DiZHGXie7/c7C/jgzfwO/LpvLfojbysPL4PBbKIvZhP36vvDle/hY7xfEoOF5enwNIPvgT+pPQSwJvu18WQM04ZJMFq4llc7gYHV1ycBvDwTF9WDwJ1M+sF4NBmVzGAZ4KOl73eWD7Wx/3DVKastjKyO647cWrsWjIJ+AIEEtbblBu1a2x0x4XNQO8wA7Rt09Jpr1axRG1JsB5Y7stp62fWgz4yZcW08C0azxciaja1SbWJkAN02s7KLtV054hsTx1llHiUzqMXzWLbGYZTC4GR5/vjguJJ3BtkZZA5Etxhk3PmnP14kg39klWRG8rfMexdmsNX89we1zzO3L4fkZMD0J+7aFgYoJGWYdF/PD8/AY/oeDOR8r+96rjfW++54zPjMm2IwXrh9b3y10GE05/ru5AqG6JspbW+DAYxc+3rf8/t9y4ORqTfR9avZ27IHoSFkJusuXxQptb23ZQ+gwHy+E1rBOHpfP78ZBozvjzuop6KDakMnqhdvjkEt8HxoGT1vAU1CH2a8E/eNtQXIYNT3x/7I73vMwocecqGPam+MgeX5o4mnTzx/0rfgo6d7wRtjkJiuUFru/FzycsdsP5283DHbTyfvDN4ZIHln8M4AyTsDNAPwmeUFMHh2eWfwzgDJO4OQwbv8P908u9uNEidyAAAAAElFTkSuQmCC)
<br>

# MVVM 패턴을 왜 공부해야 할까? 🙄

<h3>내가 맨처음 시작했을 때, 액티비티안에 모든 기능 소스를 넣었다.<br>
 그러다 보니 앱이 무거워지고, 어디에 무엇을 수정해야할지 참 골치 아팠다.
이렇게 코드를 게속 짜다 보니 디자이 패턴 의 필요성을 알게 되었고, 
*Android* 개발할 때 흔히 쓰인다고 하는 **MVVM** 패턴에 대해 알아봤다.</h3>

----------

<br>

# AAC MVVM 패턴의 구성요소와, 기능들 😄


 
  ## View

- <h3> 안드로이드의 **UI** 를 담당하는 프래그먼트, 액티비티를 의미한다.</h3> 
- <h3>화면에 그릴 것을 결정하고, 사용자와 상호작용 한다.</h3>
- <h3>데이터 변화를 감지하는 옵저버를 가지고 있다. </h3>

<h2> ViewModel</h2>

- <h3>**UI**를 그리는 데이터를 가지고 있으며, 변경되어도 괜찮다.</h3>

> 예제 소스
<h3>

```
@InternalCoroutinesApi
class ToDoViewModel(application: Application) : AndroidViewModel(application) {

    private val toDoDao = ToDoDatabase.getDatabase(
        application
    ).toDoDao()
    private val repository: ToDoRepository = ToDoRepository(toDoDao)
    val getAllData: LiveData<List<ToDoData>> = repository.getAllData


    fun insertData(toDoData: ToDoData) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.insertData(toDoData)
        }
    }

    fun updateData(toDoData: ToDoData) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.updateData(toDoData)
        }
    }

    fun deleteItem(toDoData: ToDoData) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteItem(toDoData)
        }
    }

    fun deleteAll() {
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteAll()
        }
    }

}
```
</h3>

<h2> LiveData</h2>

- <h3>**Observer** 형식으로, 데이터 변경이 일어나면 감지가 가능하다.</h3>
- <h3>**UI** 와 데이터를 일치 시킬 수 있다.</h3>

<h2> Repository </h2>

- <h3>뷰모델과 상호작용하기 위해 잘 정리된(Clean) 데이터 API를 들고 있는 클래스이다. 앱에 필요한 데이터, 즉 내장 데이터베이스나 외부 웹 서버 등에서 데이터를 가져온다. 따라서 뷰모델은 DB나 서버에 직접 접근하지 않고, 리포지토리에 접근하는 것으로 앱의 데이터를 관리한다. </h3>

<h2> Room </h2>

- <h3>*Room 은 SQLlite 의 상위 버전으로, 더 직관이고 편리하게 DB를 사용할 수 있다. </h3>

<h2> Koin</h2>

- 공부중..

---
# MVVM 패턴의 장점은 무엇일까? 😀

- 1.  <h3>View가 data를 실시간으로 관찰이 가능해, 데이터와 불일치 확률을 줄여준다. (LiveData)  </h3>
- 2. <h3> 뷰모델을 통해 데이터를 참조하기 때문에 액티비티/프래그먼트의 생명주기를 따르지 않는다. 화면전환과 같이 액티비티가 파괴된 후 재구성 되어도 뷰모델이 데이터를 홀드하고 있기 때문에 영향을 받지 않는다. 또한 뷰가 활성화되어있을 경우에만 작동하기 때문에 불필요한 메모리 사용을 줄일 수 있다.</h3>
- 3.  <h3>기능별로 모듈화 되어있어, 역할 분리할수 있고 테스트 하기 쉽다.</h3>
  


# MVVM 패턴의 단점은 무엇일까? 😖

- <h3>MVVM 패턴의 단점은 class를 많이 만들어야하고, 서로 코딩하여 연결 시켜주어야 한다. 이 과정이 복잡해지면 시간이 많이 든다.</h3>


---
# 마무리..

<h3>MVVM 패턴을 공부하면서, 무척 편리하게 쓸 수 있다는걸 배웠다. 
<br>
MVVM 패턴 뿐만아니라 MVP, MVC 등 여러 디자인 패턴을 추가로 배워 상황에 따라 유동적으로 쓸수 있도록 공부해야 겠다.</h3>











