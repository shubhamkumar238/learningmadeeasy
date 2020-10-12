import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FeaturedTeacherComponent } from './featured-teacher.component';

describe('FeaturedTeacherComponent', () => {
  let component: FeaturedTeacherComponent;
  let fixture: ComponentFixture<FeaturedTeacherComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ FeaturedTeacherComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(FeaturedTeacherComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
