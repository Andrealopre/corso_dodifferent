import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GestioneAttivita } from './gestione-attivita';

describe('GestioneAttivita', () => {
  let component: GestioneAttivita;
  let fixture: ComponentFixture<GestioneAttivita>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [GestioneAttivita],
    }).compileComponents();

    fixture = TestBed.createComponent(GestioneAttivita);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
