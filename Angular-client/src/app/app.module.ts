import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';
import { SliderComponent } from './slider/slider.component';
import { CourseCategoryComponent } from './course-category/course-category.component';
import { FeaturedCourseComponent } from './featured-course/featured-course.component';
import { FeaturedTeacherComponent } from './featured-teacher/featured-teacher.component';
import { EventsComponent } from './events/events.component';
import { HomepageComponent } from './homepage/homepage.component';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    FooterComponent,
    SliderComponent,
    CourseCategoryComponent,
    FeaturedCourseComponent,
    FeaturedTeacherComponent,
    EventsComponent,
    HomepageComponent,
  ],
  imports: [
    BrowserModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
