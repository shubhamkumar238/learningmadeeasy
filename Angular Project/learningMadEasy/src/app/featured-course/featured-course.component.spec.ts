import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FeaturedCourseComponent } from './featured-course.component';

describe('FeaturedCourseComponent', () => {
  let component: FeaturedCourseComponent;
  let fixture: ComponentFixture<FeaturedCourseComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ FeaturedCourseComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(FeaturedCourseComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
