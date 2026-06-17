import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PipeComponent } from './pipe-component';

describe('PipeComponent', () => {
  let component: PipeComponent;
  let fixture: ComponentFixture<PipeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [PipeComponent],
    }).compileComponents();

    fixture = TestBed.createComponent(PipeComponent);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
