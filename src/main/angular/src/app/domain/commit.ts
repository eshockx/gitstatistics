export class Commit {
  id: string;
  repoId: string;
  shortMessage: string;
  authorName: string;
  authorEmail: string;
  authorWhen: Date;
  insertion: number;
  deletion: number;
  ignored: boolean;
}
